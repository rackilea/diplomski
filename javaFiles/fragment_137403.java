for(int i = 1; i <= guessNumber; i++)

    {   
        Scanner textScan2 = new Scanner(file1);         
        System.out.println("Type in your guess as a letter ");
        String guess = keyboard.next();
        //System.out.print(guess);

     while ( textScan2.hasNext() )
    {

         String word1 = textScan2.next();
        if (wordLength != word1.length() || (word1.contains(guess)))
            {
            wordList.remove(word1);
            }





    }
    }