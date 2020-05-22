// use a Scanner parameter
public static Airline AddAirline(Scanner sc) {
    // don't re-create the Scanner object
    // Scanner sc = new Scanner(System.in);
    System.out.println("Please enter the Airline name: ");
    String airName = sc.nextLine();
    System.out.println("Please enter the Airline code: ");
    String airCode = sc.nextLine();

    // ..... other code

    // create your Airline object
    Airline airline = new Airline(airName, airCode); // plus other parameters in the complete class
    return airline;  // and return it

    // !! the code below should be part of the calling code
    // System.out.println(airName + " successfully added. Press Enter to continue.");
    // sc.nextLine();// Press Enter to continue
    // sc.nextLine();
    // !! A8MainMenu.mainMenu(); // NO!! Don't do this
}