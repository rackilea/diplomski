while (!userCorrect) {
        //Scanner input = new Scanner(System.in);
        System.out.print("Guessing (round " + roundNumber + "): Choosing your letter from a-z: ");
        char letter=0;
        try
        {
             letter=System.in.read();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //String letter = input.nextLine();
        for (int i=0; i < your_answer_string_length; i++)
        {
            //this is where I'm getting lost
            System.out.print("_");
        }
        System.out.println(letter);
        System.out.println("end (round " + roundNumber + ")");
        roundNumber++; 
    }