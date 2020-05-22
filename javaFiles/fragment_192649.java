public static String guessNotification(String word, char userGuess, StringBuilder dashes) {

        int guessedIndex = word.indexOf(userGuess);
        if (guessedIndex != -1 && (userGuess >= 'a' && userGuess <= 'z')) {

            letterGuessed = "There is a " + userGuess + " in the word";
            dashes.setCharAt(guessedIndex*3+1, userGuess);

        }

        else if (guessedIndex == -1 && (userGuess >= 'a' && userGuess <= 'z')) {

            letterGuessed = "No " + userGuess + " in the word";
            guesses++;

        }
        else {

            letterGuessed = "Not a valid letter";

        }

        return letterGuessed;

    }