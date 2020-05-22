import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //declarations
        Scanner keyboard = new Scanner(System.in);

        //input section
        System.out.print("Enter Your First Name: ");
        String first = keyboard.nextLine();
        System.out.print("Enter Your Middle Name: ");
        String middle = keyboard.nextLine();
        System.out.print("Enter Your Last Name: ");
        String last = keyboard.nextLine();
        System.out.print("Enter Your Favorite Phrase: ");
        //int stringSize; // dont think you need this
        String phrase = keyboard.nextLine();
        String upper = phrase.toUpperCase();
        String lower = phrase.toLowerCase();

        //processing
        String initials = first.substring(0, 1) + middle.substring(0, 1) + last.substring(0, 1);
        System.out.println("Your initials are: " + initials);
        System.out.println("Your phrase in all CAPS: " + upper);
        System.out.println("Your phrase in all lower case: " + lower);
    }
}