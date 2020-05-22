new Thread(new Runnable() {
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            // always a good pattern
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return;
        }
    }
}, "Sleeping-Thread").start();