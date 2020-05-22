import java.util.Scanner;

public class SplitString 
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in/*Taking input from standard input*/);
        System.out.print("Enter any string=");
        String userInput = scan.nextLine();//Taking input from user
        String splittedString[] = userInput.split(" ");//Splitting string with space
    }
}