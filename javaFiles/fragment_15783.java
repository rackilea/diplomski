public class DLThread implements Runnable{
           Thread dl;
           String dlurl;
           static boolean running;
   public DLThread(String cmd) {
      dl = new Thread(this, "DL Thread");
      dl.start(); 
      dlurl = cmd.substring(3);
   }
   @Override
   public void run()  {
       running = true;
      System.out.println("Thread is Running");

       try{
            Methods.downloadExecute(dlurl);
            running = false;
                    System.out.println("Thread done");

       }
       catch(Exception e){
           e.printStackTrace();
           running = false;
                   System.out.println("Thread done");

       }

   }

       public static boolean getState() {
        return running;
    }

}