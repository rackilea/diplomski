try 
    {
        out = new BufferedWriter(new FileWriter("outagain.txt"));
        userInput = new Scanner(System.in);

        String input = userInput.nextLine();    //Store first input line in the variable
        String Termination_Word = ":END";
        while(!input.equals(Termination_Word))  //Everytime Check it with the termination word.
        {
            out.write(input);                   //If it isnot a termination word, Write it to the file.
            out.newLine();
            input=userInput.nextLine();         //Take other line as an input.
        }
    } 
    finally 
    {
        if (userInput != null)
            userInput.close();
        if (out != null)
            out.close();
    }