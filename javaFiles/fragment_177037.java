public class DeadLockServlet extends HttpServlet {
       private static long sleepMillis = 10000;
       private final Object lock1 = new Object();
       private final Object lock2 = new Object();

   private boolean switch = true;

   public void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException  {

        if(switch){
            switch=!switch;
            lock12();
        }
        else{
            switch=!switch;
            lock21();
        }
        PrintWriter out = res.getWriter();
        out.println("Done!");
        out.close();
  }

   private void lock12() {
       synchronized (lock1) {
           sleep();
           synchronized (lock2) {
               sleep();
           }
       }
   }

   private void lock21() {
       synchronized (lock2) {
           sleep();
           synchronized (lock1) {
               sleep();
           }
       }
   }

   private void sleep() {
       try {
           Thread.sleep(sleepMillis);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }

}