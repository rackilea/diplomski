String guessString="";
        int guess = 0;
        Scanner input = new Scanner(System.in);
        int sum = 12;
        //just used 12 as a placeholder, you'll have to connect your 
        //random number generator, as well as changing the default of 
        //guess=0 if 0 is in your range for the random number

        while(sum!=guess){

            System.out.println("Try guessing the number: ");
            guessString=input.next();
            try {
                guess = Integer.parseInt(guessString);
            } catch(Exception e) {
                System.out.println("Invalid Data.");
                guess=0;
            }

        }
        System.out.println("You have guessed it correctly");