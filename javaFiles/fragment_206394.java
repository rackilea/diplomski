public class ThreadTest {

   public static void main(String args[]) {
       Thread t1 = new Thread(new Thread1());
       Thread t2 = new Thread(new Thread2());
       t1.start();
       t2.start();
   }

}

public class Thread1 implements Runnable {

   @Override
   public void run() {
       for (int i = 0; i < 200000; i++) {
            System.out.println(new java.util.Date());
        }
    }

}

public class Thread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 200000; i++) {
           System.out.println(i);
        }
    }

}