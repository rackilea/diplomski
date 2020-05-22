import java.util.InputMismatchException;
import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {
        float input = 0; 
        float sum = 0; 
        int count = 0; 
        boolean attempt = true;
        Scanner in = new Scanner(System.in); 

        while (attempt)
        {
            try
            {
                System.out.print("Enter a number: "); 
                input = in.nextFloat(); 
                sum += input; 
            }
            catch(InputMismatchException e)
            {
                in.nextLine();
                System.out.println("Not a number. Try again"); 
                count ++;
                if (count >=2)
                {
                  attempt = false; 
                }
            }
        }

        System.out.println("Sum: " + sum);
    }
}