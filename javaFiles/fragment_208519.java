public static void isGuessCorrect(String guess, String wordInPlay, String[] hangmanScores) {

    char[] letterGuessedAgainst = wordInPlay.toCharArray(); //Changed to Char Array

    for (int i = 0; i < letterGuessedAgainst.length; i++) {
        System.out.print(letterGuessedAgainst[i]);
    }

    System.out.println("Letter guessed against is: " + letterGuessedAgainst[1]);//testing purposes
    System.out.println("My guess is: " + guess.charAt(0));//testing purposes

    for (int i = 0; i < letterGuessedAgainst.length; i++) {
        if (letterGuessedAgainst[i] == guess.charAt(0)) {//Made == since they are all Chars now
            //System.out.println("Nice guess! Here are all the "+guess+"'s in the word.");
            //System.out.println(hangmanScores);
            System.out.println("they're equal");//want it to return this
        }//end if
        else {
            System.out.println("they're not");//returns this instead
        }
    }//end for
}//end method