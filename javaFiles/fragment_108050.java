public static void main(String[] args) {
    Runnable r = new Runnable() {
        public void run() {
            while (true) {
                System.out.println("still running...");
                try {
                    Thread.sleep(1000L);
                }
                catch (InterruptedException e) {
                    // ignore: I don't want to die
                }
            }
        }
    };

    Thread neverEndingThread = new Thread(r);
    neverEndingThread.start();

    List<byte[]> arrays = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
        byte[] hugeArray = new byte[2_000_000_000];
        arrays.add(hugeArray);
    }
    System.out.println(arrays);
}