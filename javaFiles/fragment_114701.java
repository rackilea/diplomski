import java.util.Scanner;

public class Validation {
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String regex = "^[a-zA-Z ]+$";
    String regex1 = "\\d[0-9]|[1-9]";
    String regex2 = "^[a-zA-Z0-9 ]+$";
    String Char;
    String num;
    String chars;
    System.out.println("WELCOME TO Mixed Martial Art's CLUB REGISTRATION");

    StringBuilder output = new StringBuilder();

    do {

        System.out.print("\nWhat Is Your Name:");
        Char = input.nextLine();

        if (Char.matches(regex))
            // System.out.println("\nWelcome:"+" "+Char);
            output.append("\nWelcome:" + " " + Char);
        else if (Char.isEmpty())
            System.out.println("String field should not be Empty.");
        else if (!Char.matches(regex))
            System.out.println("Please Enter A Valid String!");
    } while (!Char.matches(regex));

    do {

        System.out.print("\nHow Old Are you:");
        num = input.nextLine();
        if (num.isEmpty())
            System.out.println("Number field should not be Empty.");
        else if (!num.matches(regex1)) {
            System.out.println("Please Enter A Valid Number!");
        } else {
            if (Integer.parseInt(num) <= 18) {
                // System.out.println("Sorry But You Are Underage.");
                output.append("\nSorry But You Are Underage.");

            } else {
                if (Integer.parseInt(num) <= 39) {
                    // System.out.println("You Are Qualified");
                    output.append("\nYou Are Qualified");
                } else {
                    // System.out.println("Opps! You Are OVER AGE!");
                    output.append("\nOpps! You Are OVER AGE!");
                }
            }
        }

    } while (!num.matches(regex1));

    System.out.println(output);

}
}