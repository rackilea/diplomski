Runnable task = new Runnable() {
    @Override
    public void run() {
        System.out.println("Done:" + new Date(System.currentTimeMillis()));
        // some long task can be here
        executor.schedule(this, 10, TimeUnit.SECONDS);
    }
};
//can be 0 if you want to run it fist time without 10 sec delay
executor.schedule(task, 10, TimeUnit.SECONDS);