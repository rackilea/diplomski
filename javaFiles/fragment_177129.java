public static void main(String[] argv) throws Exception {
    MyThread s = new MyThread();
    s.start();
    Thread.sleep(1000);
    s.m();
}

class MyThread extends Thread {

    @Override
    public void run() {
        k();
    }

    private boolean done = false;

    public void k() {
        System.out.println("before wait");
        while (!done) {
            System.out.println("waiting");
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }

        System.out.println("do something after wait");
    }

    public void m() {
        for (int i = 0; i < 6; i++) {
            System.out.println(i);
        }
        synchronized (this) {
            done = true;
            notify();
        }
    }
}