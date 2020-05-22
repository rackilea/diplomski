while (true) { 
  if (missedCount>maxGuesses){
   // Print info on max guesses reached
   break;
  }
  // Does the read input stuff
  if (word.equals(hiddenWord)){
   // Print info on word was guessed
   break;
  }
}