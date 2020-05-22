import java.util.Scanner;

public class Activity7
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("How many numbers?");
    int quantityOfNumbers = keyboard.nextInt();

    int[] numbers = new int[20]; //making an array the size of 20

    //0 - 19 (Valid values of the array)
    for (int subscript = 0; subscript < quantityOfNumbers; subscript++)
    {
      System.out.println("Enter number " + subscript);
      numbers[subscript] = keyboard.nextInt();
    }
    System.out.println("Array Contents");
    for (int subscript = 19; subscript >= 0; subscript--)
    {
      if (subscript >= quantityOfNumbers) System.out.println("Subscript " + subscript + "is empty");
      else System.out.println("Subscript " + subscript + "contains " + numbers[subscript]);
    }
  }
}