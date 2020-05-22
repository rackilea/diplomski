import java.util.*;

public class OrderNumbers {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int input1;
    int input2;
    int input3;

    System.out.print("Enter the first number: ");
    input1 = scan.nextInt();

    System.out.print("Enter the second number: ");
    input2 = scan.nextInt();

    System.out.print("Enter the third number: ");
    input3 = scan.nextInt();
  }

  {
    if ((input1 > input2 && input1 > input3))

    {
      if (input2 > input3) {
        System.out.print(input3 + "," + input2 + "," + input1);
      } else
        System.out.print(input2 + "," + input3 + "," + input1);
    } else if ((input2 > input1 && input2 > input3))

    {
      if (input1 > input3) {
        System.out.print(input3 + "," + input1 + "," + input2);
      } else {
        System.out.print(input1 + "," + input3 + "," + input2);
      }
    } else if ((input3 > input1 && input3 > input2))

    {
      if (input1 > input2) {
        System.out.print(input2 + "," + input1 + "," + input3);
      } else
        System.out.print(input1 + "," + input2 + "," + input3);
    } else {
      System.out.println("ERROR!");

    }
  }
}