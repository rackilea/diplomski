class Bot {
    Thread thread = null;
    private String name;
    volatile boolean stop = false;
    Bot(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void run() {
        thread = new Thread(new Runnable(){
            public void run(){
                while(!stop) {
                    ...
                }
            }
        };
        thread.start();
    }
    public void stop() {
        stop = true;
    }
}