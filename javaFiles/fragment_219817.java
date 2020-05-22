import java.util.Scanner;

public class FirstProgram {
  // I have removed the Console variable, you don't need that.
  // System.out.println prints to the console.

  // Use constants for any number or string used to give them meaning
  private static final int DEVILS_NUMBER = 666;

  public static void main(String[] args) {
    System.out.println("Hello out there.");
    System.out.println("I will add two numbers for you.");
    System.out.println("Enter two whole numbers on a line:");

    Scanner keyboard = new Scanner(System.in);
    // declare variables next to where they are used.
    // additionally, never declare more than one variable per line.
    // never do this: int n1, n2;
    int n1 = keyboard.nextInt();
    int n2 = keyboard.nextInt();
    // store the sum in a variable so you can refer to it without doing the sum many times
    int sum = n1 + n2;

    //If the sum IS DEVILS_NUMBER, I don't want it to print the above lines, just the one below.
    // always test the positive possibility first, never the negation
    if (DEVILS_NUMBER == sum) {
      System.out.println("Nice try, Satan");
    } else {
      //This should print normally when the sum is anything BUT DEVILS_NUMBER
      System.out.println("The sum of those two numbers is");
      System.out.println(n1 + n2);
    }
}