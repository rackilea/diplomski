public class NotifyAndWaitExample2 {
    private static int[] i = {0};

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (i) {
                    if (i[0] <= 0) {
                        System.out.println("i=" + i[0] + " in t1");
                        System.out.println(Thread.currentThread().getName() + " is running");
                        try {
                            i.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " is waken up");
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (i) {
                    i[0]++;
                    System.out.println("i=" + i[0] + "in t4");
                    System.out.println(Thread.currentThread().getName() + " is notifying");
                    try {
                        Thread.sleep(1000);
                        i.notifyAll();
                        System.out.println("notifying");
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t4.start();
    }
}