import java.util.Scanner;

public class test {

  public static void main(String args[]) {

    int a = 1000;
    while (a > 0) {
      System.out.println("Question to prevent infinite while loop");

      Scanner input = new Scanner(System.in);

      int inzet = input.nextInt();

      System.out.println(a);
      a = test(a);
    }
  }

  public static int test(int a) {
    System.out.println(a);
    a = a + 100;
    System.out.println(a);
    return a;
  }
}