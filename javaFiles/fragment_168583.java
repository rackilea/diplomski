JOptionPane.showMessageDialog(null, "\nWelcome to Guess-       My-Number\nA GAME of CHANCE and SKILL\nLet's Play!\n\n");

         final int NUMBER_TO_GUESS = 13;

         //good or bad guess??
         String myGuess;
         int myGuess_int;
         do{
            // input number
            myGuess = JOptionPane.showInputDialog("Enter a number between 1 and 25:");
            myGuess_int = Integer.parseInt(myGuess);
            if(myGuess_int < NUMBER_TO_GUESS) //too low
            {
               String message = String.format("Your guess [ %s ] is too low...\nTry Again!\n", myGuess);
               JOptionPane.showMessageDialog(null, message);   
            } 
            else //too high
            {
               String message = String.format("Your guess [ %s ] is too high...\nTry Again!\n", myGuess);
               JOptionPane.showMessageDialog(null, message);             
            }

            JOptionPane.showInputDialog("Enter a number between 1 and 25:");
            myGuess_int = Integer.parseInt(myGuess);    

          }while(myGuess_int != NUMBER_TO_GUESS);//end while


          String message = String.format("Your guess [ %s ] is the number...\nCongratulations!\n", myGuess);
          JOptionPane.showMessageDialog(null, message);


      } //end main

   } //end class