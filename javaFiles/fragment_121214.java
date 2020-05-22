public class Main {
   public static void main(String[] args) {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException ex) {
        System.out.println("Error");
      }
  }
}