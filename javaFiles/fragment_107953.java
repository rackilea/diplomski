new Thread(new Runnable() {

    @Override
    public void run() {
        aFunctionThatRunsAsynchronously();
    }
}).start();