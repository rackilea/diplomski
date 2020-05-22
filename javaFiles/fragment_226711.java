while (lettersGuessed < Word.length()){
        for (int i=0; i < Word.length(); i++)
        {

            if (Word.charAt(i) == letterGuess)
            {
                dashWordB.setCharAt(i,letterGuess);
                lettersGuessed++;
                System.out.println("letters guessed: " + lettersGuessed);
                System.out.println("word length: " + Word.length());
            }
            if (i == (Word.length() - 1))
            {
                i = -1;
                System.out.println(dashWordB);
                System.out.println("Have another guess: ");
                letterGuess = kybd.next().charAt(0);
            }

            if(lettersGuessed == Word.length()){
                break;
            }

        }
    }