import java.util.Scanner;
class AlgebraTutor {
  private static Scanner in = new Scanner(System.in);
  public static void main(String[] args) {
      int x = ((int)(Math.random() * 200) -99);
      int m = ((int)(Math.random() * 200) -99);
      int b = ((int)(Math.random() * 200) -99);
      int y = m*x+b;
      System.out.println("X = " + x);
      System.out.println("M = " + m);
      System.out.println("B = " + b);
      int INPUT = in.nextInt();
      if(INPUT == y){
         System.out.println("You Got It Right!");
         System.out.println("Y = " + y);
      } else {
         System.out.println("You Got It Wrong :(");
         System.out.println("The Answer was: Y = " + y);

      }
   }
}