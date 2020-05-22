// Class Member Variables
static Scanner keyBoardInput = new Scanner(System.in);
static String userInput;
static String userClass = ""; 
static String[] RANKS = {"Farmer", "Wanderer", "Trader", "Nothing"};
static String LS = System.lineSeparator();

public static void main(String args[]) {
    System.out.println("\nNow, before we start you need to choose a class." + LS
                     + "Each Class will offer diffrent benefits.");
    int rank = getRank();
    userClass = RANKS[rank];
    System.out.println("Your chosen Class is:  " + userClass);
}

public static int getRank() {
    int maxRank = (RANKS.length - 1);
    // Displays the RANKS array
    for (int a = 0; a < RANKS.length; a++) { 
        System.out.println("[" + a + "]- " + RANKS[a]); 
    }

    // Allow User to select a Rank
    int rank = -1;
    do {
        System.out.println("What would you like to be? (0 to " + maxRank + 
                           " or q to quit)"); //ask for input
        userInput = keyBoardInput.nextLine();

        // Quit game if desired.
        if (userInput.equalsIgnoreCase("q")) {
            System.out.println(LS + "Thanks for playing...Bye Bye.");
            System.exit(0);
        }

        // Make sure a valid numerical value was supplied!
        if (!userInput.matches("\\d") || Integer.parseInt(userInput) < 0 || 
                               Integer.parseInt(userInput) > maxRank) {
            System.out.println("Invalid input! You can only supply a value "
                             + "from 0 to " + maxRank); 
            userInput = "no";
            continue;
        }
        rank = Integer.parseInt(userInput); // Store for for array index use and returning
        String message = "";

        // Farmer (0)
        switch (rank) {
            case 0:
                message = LS + "Your health will be increased by 1 permanently.";
                break;
            case 1:
                //if input is this then...
                message = LS + "You will have a dagger.";
                break;
            case 2:
                message = LS + "You will have 1 health potion. Drink it to regain 3 HP.";
                break;
            case 3:
                message = LS + "You are just a normal human. You get nothing.";
                break;
            default:
                break;
        }

        System.out.println(message);
        System.out.println("Are you sure you want to be " + RANKS[rank] + "?");
        userInput = keyBoardInput.nextLine();

    } while (userInput.equalsIgnoreCase("no")); //loops while user types no

    return rank;  // Return the index value for the chosen Rank. 
}