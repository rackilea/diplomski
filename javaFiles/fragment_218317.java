int guessInt;
try {
    guessInt = Integer.parseInt(myGuess);
}
catch(NumberFormatException ex) {
  //They didn't enter a number.  Pop up a toast or warn them in some other way
  return;
}