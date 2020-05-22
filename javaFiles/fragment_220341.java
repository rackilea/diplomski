public class ThreadDemo {
   public static void main(String args[]) {
        System.out.println(Thread.currentThread());
        Runnable r = new MyRunnable();
        new Thread(new ThreadGroup("my group"), r).start();
        try {
            for (int i = 1; i <= 5; i++) {
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class MyRunnable implements Runnable {

    public void run() {
        Thread.currentThread().setName("mythread");
        System.out.println(Thread.currentThread());
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
                //System.out.println("MyThread i value "+i);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}