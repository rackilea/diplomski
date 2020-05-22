import java.util.Scanner;

   public class Test {

public static void main(String[] args) {

    int hourValue = 0;
    Scanner in;
    while (!(hourValue > 0 && hourValue <= 12)) {
        System. out.println("Please enter the hours (between 1 and 12): ");                                  
        in = new Scanner(System.in); // User input hour value.

        hourValue = in.nextInt();

        if (!(hourValue > 0 && hourValue <= 12)) {
            System.out.println("Hour Value should be between 1 and 12,
                        please try again "); // invalid hours.

        }
    }

    int minuteValue;
    System.out.println("Please enter the minutes (between 1 and 60): ");
        // The program prompts for the hour.
    in = new Scanner(System.in); // User input hour value.

    minuteValue = in.nextInt();

    if (!(minuteValue >= 0 && minuteValue <= 60)) {
        System.out.println("Minute Value should be between 0 and 60,
                     please  try again "); // invalid minutes.
        return;

    }
}