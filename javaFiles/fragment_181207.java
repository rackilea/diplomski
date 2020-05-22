char letter = 0; //declares and initailise letter
        String [] words = { "gluttony", "lust", "greed", "pride", "despair", "wrath", "vainglory", "rhythm", "delicious", "better", "jacuzzi" , "ironman", "captainamerica", "thor", "hulk", "spiderman", "antman", "batman"}; //declares and initailise array of words to guess
        String word = words[(int) (Math.random() * words.length)]; //chooses random word from the word array
        String [] marks = new String[word.length()];
        for (int i=0;i<word.length(); i++) // for method for displaying the correct word as dashes
        {
            marks[i] = "-"; //dashes to represent the correct word.
        }

        HashSet<Character> lettersGuessed = new HashSet<>(); //keep track of letters guessed
        Scanner input = new Scanner(System.in);
        String userInput = "";
        String currentWord = "";

        while(true)
        {
            System.out.print("Word is - ");
            currentWord = "";
            for(int i = 0; i < marks.length; i++)
            {
                System.out.print(marks[i]);
            }

            System.out.print("\nGuess a letter - ");
            userInput = input.nextLine(); //always grab lines
            if(userInput.length() != 1)
            {
                System.out.println("Invalid guess - " + userInput);
            }
            else if(lettersGuessed.contains(userInput.charAt(0)))
            {
                System.out.println("You already guess that character - " + userInput);
            }
            else if(word.contains(userInput))
            {
                lettersGuessed.add(userInput.charAt(0));
                currentWord = "";
                for(int i = 0; i < word.length(); i++)
                {
                    if(word.charAt(i) == userInput.charAt(0))
                    {
                        marks[i] = "" + userInput.charAt(0);
                    }
                    currentWord += marks[i];
                }
            }

            if(currentWord.equals(word))
                break;
        }

        System.out.println("You guessed it! The word was " + word + "!");