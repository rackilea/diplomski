class T1 extends Thread
{
   private SharedClass s;
   private int t;
   T1 (SharedClass s)
   {
      this.s = s;
   }

   public void run ()
   {
       while(true) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        s.setSharedTime (++t);
        System.out.println (t + " displayed by T1");
       }
   }
}

class T2 extends Thread {
    private SharedClass s;

       T2 (SharedClass s)
       {
          this.s = s;
       }

       public void run ()
       {
          while(true) { 
          int t;
          t = s.getSharedTime ();
          System.out.println (t + " displayed by T2 after 15 seconds.");
          }
       }
}

public class SharedClass {
private int time;
private boolean shareable = true;

public static void main(String[] args) {
    SharedClass s = new SharedClass ();
    new T1 (s).start ();
    new T2 (s).start ();
}
synchronized void setSharedTime (int c)
{
   while (!shareable)
      try
      {
         wait ();
      }
      catch (InterruptedException e) {}

   this.time = c;
   if(c%15==0)
   shareable = false;
   notify ();
}

synchronized int getSharedTime ()
{
   while (shareable)
      try
      {
         wait ();
      }
      catch (InterruptedException e) { }

   shareable = true;
   notify ();

   return time;
}
}