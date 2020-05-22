public static void main(String[] args) {

    System.out.println("WELCOME TO GUESSING GAME BY JOSH!");
    System.out.println("Rules: Player 1 picks number between 1 - 100 while Player 2 has 10 tries to guess");

    Scanner josh = new Scanner(System.in);

    int guess = 0; // Create these variables up here to access them everywhere in "main"
    int counter = 0;

    boolean continueTheGame = true; // A boolean variable that holds ONLY either true or false

    System.out.println("Enter name here PLAYER 1: ");

    String p1 = josh.nextLine();

    System.out.println("Enter name here PLAYER 2: ");
    String p2 = josh.nextLine();

    System.out.println("Ok, " +  p2 + " look away. " +  p1 + ", Please enter a number and press enter:");

    int answer = josh.nextInt();

    // A while loop will continue as long as a boolean expression is true.
    // So, we create a boolean variable somewhere above called "continueTheGame"
    // As long as this is true, the code INSIDE of the while loop's brackets will repeat.

    // If the user has less than zero guesses left, we can set the variable to false,
    // which will make the loop stop!

    while (continueTheGame == true) { // The start of the while loop

        if (answer >= 100) {

            System.out.println("BUSTED! I said a number between 1 - 100!");

        } else if (answer <= 100) { 

            System.out.println("Guess in the space below.");
            guess = josh.nextInt();

        }

        if (guess == answer) {
            System.out.println("CORRECT!!!!!");
        } else if (guess != answer) {
            counter--;
            System.out.println("You have " + counter + " of guesses left");

            if (counter > 0) { // If they have MORE than zero guesses left, loop again!
                continueTheGame = true;
            } else { // If they have zero guesses left, make it stop looping
                continueTheGame = false;
            }
        }

    }

    // Once the loop ends, the code will start again here,
    // because the bracket above is the final bracket of the WHILE loop

}