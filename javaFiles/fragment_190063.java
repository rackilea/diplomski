import java.util.Scanner;
class AlgebraTutor {
  private static Scanner in = new Scanner(System.in);
  public static void main(String[] args) {
      int x = ((int)(Math.random() * 200) -99);
      int m = ((int)(Math.random() * 200) -99);
      int b = ((int)(Math.random() * 200) -99);
      System.out.println("X = " + x);
      System.out.println("M = " + m);
      System.out.println("B = " + b);
      System.out.println("Y = " + m*x+b);

  }
}