import java.util.*;
public class Pr6{
  public static void main(String[] args){
    Scanner scan = new Scanner (System.in);
    int num1;
    int num2;
    int num3;
    int sumSecToLast;
    
    System.out.print("Please write an integer: ");
    num1 = scan.nextInt();
    System.out.print("Please write an integer: ");
    num2 = scan.nextInt();
    System.out.print("Please write an integer: ");
    num3 = scan.nextInt();
    
    sumSecToLast = ((num1/10) % 10) + ((num2/10) % 10) + ((num3/10) % 10);
    System.out.println("The subtotal of the 2nd to the last digit = " + sumSecToLast);
    
    if (sumSecToLast % 2 == 0)
      System.out.println(sumSecToLast + " is an even number.");
    else
      System.out.println(sumSecToLast + " is an odd number.");
    
  }//main
}//Pr6