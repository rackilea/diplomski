for (int i = 0; i < word.length(); i++) { //check if the letter is correct
        if (word.charAt(i) == letter && wordToShow.charAt(i) == '_') 
        {   //checking only free spaces _
            System.out.println("Good!");
            wordToShow.setCharAt(i, letter);  //change '_' to the letter guessed
            guessed += letter;                  //save the letter
            guessed += '+';                     //mark the success
            if (wordToShow.indexOf("_") == -1) 
            {   //if there more unsolved letters?
                return true;        //there is no '_' symbols, all letters on their places
            }      
            break;
        }
}