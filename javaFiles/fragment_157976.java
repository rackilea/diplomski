import java.util.Scanner;

public class test {

  private static int a = 1000;

  public static void main(String args[]) {

    while (a > 0) {
      System.out.println("Question to prevent infinite while loop");

      Scanner input = new Scanner(System.in);

      int inzet = input.nextInt();

      System.out.println(a);
      test();
    }
  }

  public static void test() {
    System.out.println(a);
    a = a + 100;
    System.out.println(a);
  }
}