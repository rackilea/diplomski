while (!(idk.equals(secretWord))) {
  counter ++;

  guess = getGuess(console);

  idk = replaceBlanks(secretWord, idk, guess);
  if (!idk.equals(secretWord)) {
    System.out.println("Your knowledge so far: " + idk);
  }
}
System.out.println("Congratulations, you discovered the word " +  "\"" + idk + "\"" + "!")
System.out.println("It took you " + counter + " guesses.");