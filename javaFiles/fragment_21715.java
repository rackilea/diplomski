Task<Void> task = new Task<Void>() {
    @Override
    protected Void call() throws Exception {
        Random random = new Random();
        while (true) {
            Thread.sleep(50);
            intValue.set(random.nextInt(images.size()));
        }
    }
};

Thread thread = new Thread(task);
thread.setDaemon(true);
thread.start();