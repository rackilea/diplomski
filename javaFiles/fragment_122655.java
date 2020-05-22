import java.util.Scanner;
import java.util.InputMismatchException;
public class ObjectOrinetPrograming
{
    public static void main( String [] args )
    {
        Scanner input = new Scanner (System.in);
        System.out.println("Please Enter elements: ");
        String employeenumber = input.nextLine();

        while (!employeenumber.matches("[0-9]{3}-[A-Ma-m]")) {
            System.out.println("invalid input; lenght, Try again:");
            employeenumber = input.nextLine();
        }

    }

}