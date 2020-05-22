import java.util.Scanner;

public class StackOverflowTest {
  static String name = "";
  static int age = -1;
  static int grade = -1;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter name or command: ");


    String[] input = sc.nextLine().split(" ");
    switch (input.length) {
      case 3: grade = Integer.valueOf(input[2]);
              // fallthrough
      case 2: age = Integer.valueOf(input[1]);
              // fallthrough
      case 1: name = input[0];
    };

    if (name.isEmpty()) {
      System.out.println("Enter name: ");
      name = sc.next();
    }   

    if (age == -1) {
      System.out.println("Enter age: ");
      age = sc.nextInt();
    }   

    if (grade == -1) {
      System.out.println("Enter grade: ");
      grade = sc.nextInt();
    }
  }
}