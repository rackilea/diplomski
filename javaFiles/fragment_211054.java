public class Main {

    public static void main(String[] args) {
        final Object lock = new Object();

        Thread t1 = new Thread(new Runnable(){
            public void run(){
                Server s = new Server(1,lock);
                s.doStuff();
            }
        });

        Thread t2 = new Thread(new Runnable(){
            public void run(){
                Server s = new Server(2,lock);
                s.doStuff();
            }
        });

        Thread t3 = new Thread(new Runnable(){
            public void run(){
                Server s = new Server(3,lock);
                s.doStuff();
            }
        });

        Thread t4 = new Thread(new Runnable(){
            public void run(){
                Server s = new Server(4,lock);
                s.doStuff();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}