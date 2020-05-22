public class TempConverter {

    // variables that are needed in more than one method must be declared outside the methods
    // (static since the methods are static; not recommended, but let it be for now)
    static double temp1;
    static String scale1;
    static String scale2;

    public static void main(String[] args) {
        // get rid of unused variables
        char cont = 'E';

        do {
            // input
            // save all inputs to variables
            temp1 = getTemp();
            // Java parameters are pass by value, so to get a value out of the method, use the returned value
            // then you don’t need the parameter
            scale1 = scaleOne();
            scale2 = toScale();

            // process
            // don’t call toScale() again, or the user will be prompted again,
            // instead, use the value already stored in scale2
            System.out.print("Your final temp is: " + convert() + ' ' + scale2);

            // you should set cont to something if you want the loop to repeat

        } while (cont == 'N');
    }

    private static double getTemp() {
        double temp;
        Scanner userIn = new Scanner(System.in);
        System.out.print("Enter a temperature to convert ");
        while (!userIn.hasNextDouble()) {
            System.out.println("That is not a valid temperature!");
            System.out.print("Re-enter a temperature: ");
            userIn.next();
        }
        temp = userIn.nextDouble();

        return temp;
    }

    private static String scaleOne() {

        Scanner userIn = new Scanner(System.in);

        // \n is a line break for readability
        System.out.print("What scale is your temp currently in?" 
                + "\n1: Fahrenheit" 
                + "\n2: Celsius" 
                + "\n3: Kelvin"
                + "\nPlease enter 1, 2, or 3: ");

        // read a value from the user
        int userChoice = userIn.nextInt();

        String scale = "";

        switch (userChoice) {
        case 1: {
            scale = "Fahrenheit";
            break;
        }

        case 2: {
            scale = "Celsius";
            break;
        }

        case 3: {
            scale = "Kelvin";
            break;
        }

        default: {
            scale = "There was an error in your choice!";
        }
        }

        return scale;

    }

    private static String toScale() {

        Scanner userIn = new Scanner(System.in);

        System.out.print("What scale would you like to convert to?" + "1: Fahrenheit" + "2: Celsius" + "3: Kelvin"
                + "Please enter 1, 2, or 3: ");

        String scale2 = "";

        int userChoice = userIn.nextInt();

        // ideally should not accept the same scale as scale1 (from scale)
        switch (userChoice) {
        case 1: {
            scale2 = "Fahrenheit";
            break;
        }

        case 2: {
            scale2 = "Celsius";
            break;
        }

        case 3: {
            scale2 = "Kelvin";
            break;
        }

        default: {
            scale2 = "There was an error in your choice!";
        }
        }

        return scale2;

    }

    public static double convert() {
        // need only one variable for result
        double converts;

        // don’t call methods again, use variables
        // don’t use == for comparing strings, use .equals
        // typo: the second scale corrected to scale2
        if (scale1.equals("Fahrenheit") && scale2.equals("Kelvin")) {
            // don’t call getTemp() again
            converts = (temp1 + 459.67) * 5 / 9;
        }

        else if (scale1.equals("Fahrenheit") && scale2.equals("Celsius")) {
            converts = (temp1 - 32) * 5 / 9;
        }

        else if (scale1.equals("Celsius") && scale2.equals("Kelvin")) {
            converts = temp1 + 273.15;
        }

        else if (scale1.equals("Celsius") && scale2.equals("Fahrenheit")) {
            converts = temp1 * 9 / 5 + 32;
        }

        else if (scale1.equals("Kelvin") && scale2.equals("Fahrenheit")) {
            converts = temp1 * 9 / 5 - 459.67;
        }

        else { // Kelvin to Celsius
            converts = temp1 - 276.15;
        }

        return converts;
    }

}