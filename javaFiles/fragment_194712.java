for (int i = 0; i < splitInput.length; i++)
        {
            word = splitInput[i];
            reverseWord = "";
            for (int j = word.length()-1; j >= 0; j--)
            {
                reverseWord = reverseWord + word.charAt(j);
            }
            splitInput[i] = reverseWord;
        }