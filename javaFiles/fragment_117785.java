public class Test {

    public static void main(String[] arg) throws Throwable {
       Thread t = new Thread() {
          public void run()   {
             while(true)   {
                try  {
                   Thread.sleep(300);
                   System.out.println("Woken up after 300ms");
                }catch(Exception e) {}
             }
          }
       };

       // t.setDaemon(true); // will make this thread daemon
       t.start();
       System.exit(0); // this will stop all threads whether are not they are daemon
       System.out.println("main method returning...");
    }
}