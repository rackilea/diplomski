import java.util.Random;

public class MyRandom {
   public static void main(String args[]) {
      Random rand = new Random(); 
      int num = rand.nextInt(40);
      System.out.println(num);
   }
}