import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Please enter a number:");
    int inputNumber = sc.nextInt();

    for(int i=0;i<inputNumber;i++) {
      System.out.print('*');
    }
  }
}