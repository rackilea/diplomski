package javaapplicationName;
import java.util.Scanner;
public class JavaApplication41 {

    public static void main(String[] args) {
        // You'd want to grab the user's
        // input so we need to initialize a scanner object.
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your first and last name");
        String str = input.nextLine();
        System.out.println("The number of characters in your name is " + (str.length() - 1));
        if (str.length() - 1 == 13) {
            System.out.println("Your name is average length.");
        } else if (str.length() - 1 > 13) {
            System.out.println("Your name is long length.");
        } else if (str.length() - 1 < 13) {
            System.out.println("Your name is short length.");
        }
    }
}