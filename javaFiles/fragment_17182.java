System.out.print("Enter a character: ");
        String userInput= keyb.next();
        char i = userInput.charAt(0);//getting the character by itself
        int counter=0;
        for(int index= 0; index< theString.length(); index++)
        {
            char ch = **theString**.charAt(index);
            if (ch==i)//comparing the chosen character to each character in the string
                counter++;//keeping track of how many times you find a match