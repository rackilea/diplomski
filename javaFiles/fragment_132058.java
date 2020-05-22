allLetters = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
usedLetters = new StringBuffer("");
try {
    secretWord = chooseSecretWord();
} catch (FileNotFoundException e) {
    // TODO Do something here, example log the error our present a error message to the user.
}          //THIS IS LINE 33
knownSoFar = new StringBuffer("");