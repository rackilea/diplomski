import java.util.Scanner;
public class Alpha 
{
public static void main(String args[])
{
    Scanner input = new Scanner(System.in);
     int n;

    System.out.println("Enter no. of stars");
    n = input.nextInt();

    Loop(n); //calls Loop function and passes parameter n
}
public static void Loop(int n)  //this function now expects a number n
{
    for (int counter = 1; counter <= n; counter++)
    {
        System.out.println("*");
    }
}
}