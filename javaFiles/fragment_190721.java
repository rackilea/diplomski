import java.util.*;

public class loops

{

public static void main (String []args)

{

    Scanner input = new Scanner (System.in).useDelimiter("\n");
    int sum=0;
    for (int i = 0; i <= 9; i++)
    {
                System.out.print("Enter your mark:  ");
                int marks = input.nextInt(); 
                sum=sum+marks;
    }


    int totalmarks = sum / 10;

    System.out.println("The class average was:"+ totalmarks + ".");
}
}