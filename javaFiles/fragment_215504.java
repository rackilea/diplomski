ExecutorService executor = Executors.newSingleThreadExecutor();

public void foo() {
    final Exception starterStackTrace = new Exception();
    executor.execute(new Runnable () {

        @Override
        public void run() {
            try {
                // do stuff
            } catch (Exception e) {
                e.printStackTrace(); // Thread exception
                starterStackTrace.printStackTrace(); // How thread was started
            }
        }
    });
}