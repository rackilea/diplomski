class MyTask implements Runnable {
    private final String needThis;
    public MyTask(String needThis) {
        this.needThis = needThis;
    }
    @Override
    public void run() {
        //do your task using needThis variable here...
    }
}