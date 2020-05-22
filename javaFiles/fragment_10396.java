package lab11;
import java.util.Scanner;
public class Lab11 {
    public static Scanner user_input;
    public static void main(String[] args) {
        user_input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        System.out.println(changeNameFormat(user_input.nextLine()));
    }
    public static String changeNameFormat(String input) { //Pass a name
        String firstName, lastName;
        firstName = input.substring(0, input.indexOf(" "));
        lastName = input.substring(input.indexOf(" ")+1, input.length());
        return lastName + ", " + firstName;
    }
}