public class MainClass {
    public static int number=0;
   public static void main(String[] args)
   {
       MainClass obj = new MainClass();
      // Boolean flag= true;
       EvenThread evenThread = new EvenThread(obj);
       OddThread oddThread = new OddThread(obj);
       Thread Even = new Thread(evenThread);
       Thread Odd = new Thread(oddThread);
       Even.setName("Even Thread");
       Odd.setName("Odd Thread");
       Even.start();
       Odd.start();
   }

   public synchronized void PrintNumbers()
   {  
       while(number<20)
       {
           System.out.println(number+"---"+Thread.currentThread().getName());
           number++;
           notifyAll();

           try {
            wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       }
   }

}




public class OddThread implements Runnable {


    MainClass obj;
    public OddThread(MainClass obj) {
        // TODO Auto-generated constructor stub
        this.obj= obj;
    }
    public void run() {

          obj.PrintNumbers();


    }

}



public class EvenThread implements Runnable{

    MainClass obj;
    public EvenThread(MainClass obj)
    {
        this.obj=obj;
    }
    public void run() {
        int number=0;

          obj.PrintNumbers();


    }

}