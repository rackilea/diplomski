String wordToGuess = "tiger";
StringBuilder wordToShow = new StringBuilder();
for (int i=0; i < wordToGuess.length(); ++i) {
    wordToShow.append("_");
}

// update publicly shown string; return true if one or more matches found,
// otherwise return false
public boolean guessLetter(char letter) {
    boolean result = false;
    for (int i=0; i < wordToGuess.length(); ++i) {
        if (wordToGuess.charAt(i) == letter) {
            // reveal the correctly guessed character
            wordToShow.setCharAt(i, letter);
            result = true;
        }
    }

    return result;
}

public String reveal() {
    return wordToShow.toString();
}