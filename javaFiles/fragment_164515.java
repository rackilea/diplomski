class MyThread extends Thread{

    public MyThread(String name) {
        super(name);
    }

    public void run() {
        try {
            while(true){
                Thread.sleep(10);
            }
        }
        catch(InterrutedException ie) {
            // leads to the end of the thread
        }
    }
}