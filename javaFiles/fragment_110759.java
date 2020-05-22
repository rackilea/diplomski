static void checkAnsw() {

if(userInput.hasNextLine()) {

    if(userInput.nextLine().equalsIgnoreCase("y")) {
        guessGame();
    } else if(userInput.nextLine().equalsIgnoreCase("n")) {

    } else {
        System.out.print("Y or N ");
        checkAnsw();
    }

    } else {
        System.out.print("Y or N ");
        userInput.next();
        checkAnsw();
    }
}