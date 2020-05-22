else 
  {
    System.out.println("Nice one! The letter '" + guess + "' was in the word!");
    for (position = 0; position < wordLength; position++) 
    {
      for (position = 0; position < wordLength; position++) 
      {
        if (word.charAt(position) == guess) 
        {
          //replacing every time * with guessed letter
          displayWord = displayWord.substring(0,position)+ guess +displayWord.substring(position + 1);
          lettersRemaining--;
        }
      } 
    }
    System.out.print(displayWord); // here we display it
  }