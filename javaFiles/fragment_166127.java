public class Test{
   public static int temp;
   public static void main(String [] args) {
      update().join(); //we wait until new thread finishes
      System.out.println("This is the content of temp"+temp);
   }

   public static Thread update() {
       Thread t = new Thread() {
          @Override
          public void run() {
             // do some stuff
             Test.temp=15;
          }
       };
       t.start();
       return t;
    }