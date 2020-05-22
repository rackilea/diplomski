public class Program extends bridge {
   Client eClient = new Client() ;
   public void main(String[] args) {...}
   public void myMethod(){...}
   class Flipper implements Runnable {
      public void run(){Program.eClient.apiMethod()}
   }
}