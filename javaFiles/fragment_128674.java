import java.util.*;
import java.lang.*;

/**
 * CS-12J
 * Sweetner.java
 * Purpose:
 *
 * @version 1.0 3/18/13
 */

public class Sweetener {

    /**
     * The main method begins the execution of the program
     *
     *@param args not used
     */

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        String again = "yes";
        while(again.equals("yes")) {
            System.out.print("Enter the dieter's name: ");
            String name = input.nextLine();
            System.out.print("Enter the target weight of the dieter in pounds: ");
            double weightInPounds = Double.valueOf(input.nextLine());

            //converts pounds to grams
            final double IBS_TO_GRAMS = 453.59;
            double weightInGrams = weightInPounds * IBS_TO_GRAMS;

            //finds lethal amout of sweetner for mouse
            double mouseWeight = 30;
            double lethalDoseMouse = 100;
            final double MOUSE_LETHAL_PROPORTION =
                    (double) lethalDoseMouse / mouseWeight;

            //finds lethal amount of sweetner for human of given weight
            double lethalSweetner = MOUSE_LETHAL_PROPORTION * weightInGrams;

            //lethal number of cans
            final double SODA_SWEETNER = 0.001;
            final double SODA_GRAMS = 350;
            double lethalCans = lethalSweetner / (SODA_SWEETNER * SODA_GRAMS);

            //output
            System.out.println("For dieter: " + name);
            System.out.println("Dieter's target weight: " + weightInPounds
                    + " pounds");
            System.out.println("Lethal dose in grams of sweetner is: "
                    + lethalSweetner);
            System.out.println("Lethal number of cans of soda: "
                    + lethalCans);

            //extra credit
            final int CANS_PER_DAY = 15;
            final double DAYS_IN_YEAR = 365.25;
            double yearsToLethal = lethalCans / (CANS_PER_DAY * DAYS_IN_YEAR);
            System.out.println("Years to lethal dose: " + yearsToLethal);
            System.out.print("Do you want to repeat the program? yes or no");
            again = input.nextLine();
        }
    }
}