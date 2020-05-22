class ThreadOne implements Runnable {
   Thread t;
   volatile MyVariables x;

   public ThreadOne(MyVariables x) {
      t = new Thread(this, "Thread One");
      this.x = x;
   }

   @Override
   public void run() {
      while (!x.startApp) {
         try {
            Thread.sleep(1);
         } catch (InterruptedException e) {
         }
      }
      System.out.println("Starting");
   }

   public void start() {
      t.start();
   }

}

class ThreadTwo implements Runnable {
   private static final int MAX_I = 10001;
   Thread t;
   volatile MyVariables x;

   public ThreadTwo(MyVariables x) {
      t = new Thread(this, "Thread One");
      this.x = x;
   }

   @Override
   public void run() {
      synchronized (this.x) {
         for (int i = 0; i <= MAX_I; i++) {
            if (i == MAX_I) {
               this.x.startApp = true;
               System.out.println(this.x.startApp);

            } else {
               System.out.println(this.x.startApp);
               System.out.println(i);
            }
         }
      }

   }

   public void start() {
      t.start();
   }

}

public class StartThreads {

   public static void main(String[] args) {
      MyVariables a = new MyVariables();
      ThreadOne x = new ThreadOne(a);
      ThreadTwo y = new ThreadTwo(a);
      x.start();
      y.start();
   }

}

class MyVariables {
   public volatile boolean startApp = false;
}