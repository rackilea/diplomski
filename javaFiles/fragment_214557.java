import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scnObj = new Scanner(System.in);
        System.out.println("enter 3 letters");
        String input1;
        do {
            input1 = scnObj.nextLine();
            if ((!Pattern.compile("[a-zA-Z]*").matcher(input1).matches())) {
                System.out.println("try again");
            }
        } while (!Pattern.compile("[a-zA-Z]*").matcher(input1).matches());

        System.out.println("enter the 2nd");
        String input2;
        do {
            input2 = scnObj.nextLine();
            if ((!Pattern.compile("[a-zA-Z]*").matcher(input2).matches())) {
                System.out.println("try again");
            }
        } while (!Pattern.compile("[a-zA-Z]*").matcher(input2).matches());

        System.out.println("enter the 3rd");
        String input3;
        do {
            input3 = scnObj.nextLine();
            if ((!Pattern.compile("[a-zA-Z]*").matcher(input3).matches())) {
                System.out.println("try again");
            }
        } while (!Pattern.compile("[a-zA-Z]*").matcher(input3).matches());

        scnObj.close();
    }
}