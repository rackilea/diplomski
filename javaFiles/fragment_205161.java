// Main method
public static void main(String[] args) {
    int[] array = new int[20]; // Declare and instantiate a new ArrayList object
    Scanner userChoice = new Scanner(System.in); // User input for quitting program
    boolean inputFlag = true; // True if input is valid, false otherwise
    String choice;

    // Repeat program until user chooses to quit
    while (inputFlag == true) {

        try {
            /* Create an array of size 20 and populate it with random integers between 1 and 1000.
             Do not ask user for the numbers and do not hard code them */
            for (int i = 0; i < 20; i++) {
                int integer = (int) (1000.0 * Math.random());
                array[i] = integer;
            }
            System.out.print("\nUNSORTED LIST: ");

            //Display the 20 size of the unsorted ArrayList 
            for (int i = 0; i < array.length - 1; i++) {
                System.out.print(array[i] + ", ");
            }
            // Shows very last integer with a period
            System.out.print(array[array.length - 1] + ".");
            System.out.println();
            doBubbleSort(array);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nThere is an out of bounds error in the ArrayList.");
        }

        System.out.print("\nWould you like to continue the program? (Y/N): ");
        choice = userChoice.nextLine();

        while (!(choice.equalsIgnoreCase("Y")) && !(choice.equalsIgnoreCase("N"))) {
            // Error message when inputting anything other than Y/N
            System.out.println("\nERROR. Only Y, y, N, or n may be inputted.");
            System.out.println("Please try again.");
            choice = userChoice.nextLine();
        }

        if (choice.equalsIgnoreCase("N")) {
            inputFlag = false;
        }

    }
}