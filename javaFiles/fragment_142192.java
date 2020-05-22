public class TestThreads {
    public static void main (String [] args) {
        Thread[] worker=new Thread[3];
        Runnable r = new MyRunnable();

        for(int i=0;i<3;i++) {
           worker[i]=new Thread(r);
           worker[i].start();
        }

         for(int i=0;i<3;i++) {
           worker[i].join();
           worker[i] = null;
        }
    }