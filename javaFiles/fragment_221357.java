package mm.com.java.so.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaRepeat {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] defaultPayRates = { 3.50, 4.00, 4.50, 4.75, 5.00, 5.25, 5.50, 5.75, 6.00 };

        double payRate;
        boolean isValid;
        boolean isContinue;
        String next;
        int workingHour;

        do {

            isValid = false;
            isContinue = false;

            System.out.print("\nEnter hours work : ");

            workingHour = Integer.parseInt(reader.readLine());

            do {

                System.out.print("Enter pay rate: ");

                payRate = Double.parseDouble(reader.readLine());

                for (int i = 0; i < defaultPayRates.length; i++) {

                    if (defaultPayRates[i] == payRate) {
                        isValid = true;
                        // TODO : make calculation here.
                        break;
                    }
                }

                if (!isValid) {
                    System.out.println("You have entered the wrong pay rate. Please try again !!!");
                }

            } while (!isValid);

            do {

                isValid = true;

                System.out.println("\nDo you have any employee to process (Y/N)");

                next = reader.readLine();

                switch (next.toLowerCase()) {
                    case "y":
                        isContinue = true;
                        break;

                    case "n":
                        isContinue = false;
                        break;

                    default:
                        isValid = false;
                        System.out.println("Please use Y or N only.");
                        break;
                }
            } while (!isValid);

        } while (isContinue);

        // TODO : print out calculation here.

        System.out.println("\nCalculation is doing. Please wait...");
    }
}