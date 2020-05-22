interface Callback {
    void callback(); // would be in any signature
}

class MyThread implements Runnable {

    Callback c; 

    public MyThread(Callback c) {
        this.c = c;
    }

    public void run() {
        // some work
        this.c.callback(); // callback
    }
}