public class print extends Thread{

     private Runnable rrr;
     public print(Runnable rrr) {
         this.rrr = rrr;
     }

     public void run()
     {
          rrr.run(); // this runs "Thread.currentThread().setName(args[0])"
          System.out.println("run() called by " +      Thread.currentThread().getName());
          System.out.println(Thread.currentThread().getName());

     }
 }