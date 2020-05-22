String highLow = "(H)igher or (L)ower: ";
     String loseHigh = "Card is higher, you lose.";
     String loseLow = "Card is lower, you lose.";
     String loseMessageDetails = "";
     boolean gameLost = false;
     boolean askAgain = true;
     Scanner scan = new Scanner(System.in);
     String guess = "";
     Random rand = new Random();

     int card1;
     int card2;

     while(askAgain)
     {   
         if(gameLost)
         {
             System.out.println(loseMessageDetails + "\nWould you like to play again? Y/N");
             guess = "";
             while(!guess.equals("Y") && !guess.equals("N"))
             {
                 guess = scan.nextLine().toUpperCase();
             }

             if(guess.equals("Y"))
             {
                 gameLost = false;
                 askAgain = true;
             }
             else
             {
                 askAgain = false;
             }
         }

         if(!gameLost)
         {
             card1 = rand.nextInt(13) + 1;
             card2 = rand.nextInt(13) + 1;
             System.out.println("Card is: " + card1);
             guess = "";
             //loop until correct type of input
             while(!guess.equals("H") && !guess.equals("L"))
             {
                 System.out.printf(highLow);
                 guess = scan.nextLine().toUpperCase();
             }
             //now we either correctly guessed or incorrectly guessed
             //here is a correct guess
             if((card1 < card2 && guess.equalsIgnoreCase("H")) ||
                (card1 > card2 && guess.equalsIgnoreCase("L")))
             {
                 askAgain = true;
             }
             else
             {
                 loseMessageDetails = guess.equalsIgnoreCase("L") ? loseHigh : loseLow;
                 gameLost = true;
             }
         }
     }