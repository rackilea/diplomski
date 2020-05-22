final Thread th2 = new Thread(new Runnable(){
    public void run(){
        doSomething2;
    }
}
Thread th1 = new Thread(new Runnable(){
    public void run(){
        doSomething;
        th2.start();
    }
});
th1.start();
th2.join();