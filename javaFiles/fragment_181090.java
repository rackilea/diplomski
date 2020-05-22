import java.util.Scanner;


public class ConversionProgram


{
    public static void showKilometers(double meters) //Converts Meters to Kilometers
    {
        double kilometers = meters * 0.001;
        System.out.println(meters + " meters is " + kilometers + " kilometers.");
    }

    public static void showInches(double meters) //Converts Meters to Inches
    {
        double inches = meters * 39.37;
        System.out.println(meters + " meters is " + inches + " inches.");
    }

    public static void showFeet(double meters) //Converts Meters to Feet
    {
        double feet = meters * 3.281;
        System.out.println(meters + " meters is " + feet + " feet.");
    }


    public static void quitProgram() {
        System.out.println("Bye!");
    }

    public static void showMenu() {
        System.out.println(" 1. Convert to Kilometers ");
        System.out.println(" 2. Convert to Inches ");
        System.out.println(" 3. Convert to Feet ");
        System.out.println(" 4. Quit the program ");
        System.out.println(" ");
    }


    public static void main(String[] args) {

        double meters;
        int choice;

        Scanner keyboard = new Scanner(System.in);

        // Loop breaker
        boolean quitFlag = false;

        // Whole program wrapped around a loop
        while (!quitFlag) {
            System.out.println("Enter a Distance in Meters: ");
            meters = keyboard.nextDouble();

            if (meters < 1) {
                System.out.println("Meter can not be negative.");
            } else showMenu();
            choice = keyboard.nextInt();
            switch (choice) {
                case 1:
                    showKilometers(meters);
                    break;

                case 2:
                    showInches(meters);
                    break;

                case 3:
                    showFeet(meters);
                    break;

                case 4:
                    quitFlag = true;
                    quitProgram();
                    break;
            }
        }
    }
}