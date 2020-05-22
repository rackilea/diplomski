public static int retrieveYearsBack() throws Exception
{
    Scanner input = new Scanner(System.in);
    while (input.hasNext()) {
        if (input.hasNextInt()) {
            int years = input.nextInt();
            if (0 <= years && years <= 136) {
                return years;
            }
        } else {
            input.next();
        }

        System.out.println("Invalid entry. Please enter a positive whole number less than 136.");
    }

    throw new Exception("Standard in was closed whilst awaiting a valid input from the user.");
}