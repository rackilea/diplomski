package stackoverflow;

import java.util.Scanner;

public class LoopTest {

public static void main(String[] args) 
{
    // TODO Auto-generated method stub

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number");

    int input  = 0;
    double sum = 0;
    double avg = 0;
    int count = 0;

    //Infinite Loop
    while (true)
    {   
        //Accept Number
        input  = scanner.nextInt();

        //Check Entered Number
        if (input  != 42)
        {
            sum = sum + input ;
            count = count + 1;
            avg = sum/count;
        }
        else
            break;
    }

    System.out.println("Numbers Entered : " + count);
    System.out.println("Sum of Numbers : " + sum);
    System.out.println("Average of Numbers : " + avg);
}

}