package threads;

import static java.lang.System.out;

class Main {
    Thread a1, a2, a3;
    int x = 0;

    public Main() {
        out.println("Current thread (in Main's constructor): " + Thread.currentThread().getName());
        a1 = new Thread(new MyRunnable(1));
        a2 = new Thread(new MyRunnable(2));
        a1.start();
        a2.start();
    }

    private synchronized void change(int who) {
        out.println("Current thread (in change() method): " + Thread.currentThread().getName());
        out.println("who called" + who);
        out.println("x initial=" + x);
        x++;
        out.println("x after=" + x);
    }

    private class MyRunnable implements Runnable {
        ThreadLocal<Integer> id = new ThreadLocal<Integer>();

        public MyRunnable(int givenid) {
            out.println("Current thread (in MyRunnable's constructor): " + Thread.currentThread().getName());
            out.println("my givenid is " + givenid);
            id.set(givenid);
            out.println("my id is " + id.get());
        }

        public void run() {
            out.println("Current thread (in run() method): " + Thread.currentThread().getName());
            out.println("im running id=" + id.get());
            change(id.get());
            out.println("after call me=" + id.get());
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}