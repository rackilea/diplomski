executor.scheduleAtFixedRate(new Runnable() {
    @Override
    public void run() {
        System.out.println("Done:" + new Date(System.currentTimeMillis()));
    }
}, /* same, can be 0*/ 10 , 10, TimeUnit.SECONDS);