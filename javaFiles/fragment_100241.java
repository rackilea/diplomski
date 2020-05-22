public static void main(String[] args) {
    final ExecutorTest et = new ExecutorTest();
    for (int i = 0; i < 50000; i++) {
        et.trigger(i);
    }
    System.out.println("Done");
}

private void trigger(int i) {

    try {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    } catch (final Exception e) {
        System.out.println("Test " + i + " with " + Thread.activeCount());
        e.printStackTrace();
    }
}