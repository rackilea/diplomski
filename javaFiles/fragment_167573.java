import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        while (true) // add the remaining logic
        {
            System.out.println("Enter time in 24-hour notation HH:MM");
            Scanner x = new Scanner(System.in);
            String newhr = x.nextLine();
            String hr[] = newhr.split(":");
            int hours = 0;
            int minutes = 0;
            try {
                hours = Integer.parseInt(hr[0]);// HH
                minutes = Integer.parseInt(hr[1]);// MM
            } catch (NumberFormatException e) {
                System.out.println("Wrong time input");
                continue;
            }
            if ((hours >= 00 && hours <= 24)
                    && (minutes >= 00 && minutes <= 59)) {
                System.out.println("That is the same as: ");
                if (hours <= 12) {
                    System.out.println(hours + ":" + minutes + " AM");
                    // System.exit(0);
                } else if (hours > 12 && hours < 24) {
                    int hoursnew = hours - 12;
                    System.out.println(hoursnew + ":" + minutes + " PM");
                    // System.exit(0);
                }
            } else {
                System.out.println("There is no such time as " + hours + " : "
                        + minutes);
                System.out.println("Try Again!");
                // continue;
            }

            while (true) {
                System.out.println("Again? [y/n]");
                Scanner y = new Scanner(System.in);
                String newyn = y.nextLine();
                if ("y".equalsIgnoreCase(newyn)) {
                    break;
                } else if ("n".equalsIgnoreCase(newyn)) {
                    System.out.println("End of program");
                    System.exit(0);
                    // break;
                } else {
                    System.out.println("Enter correct input Y or N");
                }
            }
            // end of while
        }
    }
}