public class WaitAndNotify {

    public static void main(String[] args) {

        final Thread haveCoffee = new Thread() {
            public void run() {
                synchronized (this) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("I am awake and ready to have coffee");
                }
            }
        };

        Thread me = new Thread() {
            public void run() {
                synchronized (haveCoffee) {
                    try {
                        System.out.print("I am Sleeping");
                        Thread.sleep(4000);
                        haveCoffee.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        haveCoffee.start();
        me.start();
    }
}