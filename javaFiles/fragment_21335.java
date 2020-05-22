Thread th1 = new Thread(new Runnable(){
    public void run(){
        doSomething;
        doSomething2;
    }
});
th1.start();
th1.join();