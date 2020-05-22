package stackoverflow;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BathRoom {
    private Lock lockW=new ReentrantLock();
    private Condition c1=lockW.newCondition();
    public int women_present;


    public BathRoom(){
        women_present=0;//empty at start
    }



    public  void woman_wants_to_enter (int i) {
         lockW.lock();
         while(women_present!=i)
            try {
                c1.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


         System.out.println ("Woman " + i + " enters bathroom ");     }
    public  void woman_leaves (int i) {
       try {
            Thread.sleep (1000);

         }catch (InterruptedException e) {
             e.printStackTrace();
         }
       System.out.println ("Woman " + i + " exits bathroom ");
       women_present++;    
       if(women_present==3){
           women_present=0;
        }
       c1.signal();
       lockW.unlock();
 }
}
class Woman implements Runnable{
    private int i; /* This identifies the woman. */
       private BathRoom bathroom;

    public Woman (BathRoom bathroom,int i) { 
          this.i = i;
          this.bathroom = bathroom;
       }

    public void run () {
     for (int i = 0; i < 3; i++) {
        try {
                Thread.sleep ((long) (500 * Math.random()));
             }catch (InterruptedException e) {
                 e.printStackTrace();
             }
             bathroom.woman_wants_to_enter (i);
             bathroom.woman_leaves (i);
          }
       }
    }

public class testdummy {

    public static void main(String[] args) {

        BathRoom b=new BathRoom();

        Woman w0=new Woman(b, 0);
        Woman w1=new Woman(b, 1);
        Woman w2=new Woman(b, 2);

        Thread A=new Thread(w0);
        Thread B=new Thread(w1);
        Thread C=new Thread(w2);

        A.start();
        B.start();
        C.start();



    }

}