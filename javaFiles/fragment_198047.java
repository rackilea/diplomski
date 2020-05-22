class Y {
    static synchronized void staticSleep() {
        System.out.println("Start static sleep");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("End static sleep");
    }

    synchronized void instanceSleep() {
        System.out.println("Start instance sleep");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        System.out.println("End instance sleep");
    }
}

public class X {
    public static void main(String[] args) {
        for (int i = 0; i < 2; ++i) {
            new Thread(new Runnable() {

                public void run() {
                    Y.staticSleep();
                }
            }).start();
        }

        for (int i = 0; i < 10; ++i) {
            new Thread(new Runnable() {

                public void run() {
                    new Y().instanceSleep();
                }
            }).start();
        }
    }
}