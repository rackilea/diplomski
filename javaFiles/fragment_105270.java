public static void main(String args[])
        {
            Scanner scan = new Scanner(System.in);      
            System.out.println("Guess the Letter");
            String myLetter=scan.nextLine();
                //get the letter of myLetter variable then convert to Uppercase
            char enteredLetter=Character.toUpperCase(myLetter.charAt(0));
                    //26 only because the characters array starts with index 0
            char[] characters ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
                    //I had created a parrallel array symbolizing int value of each letter
            int[] range={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
            //this variable convert user input to one of the array element of range
            int userInputToInt=0;
            //this variable is for knowing what int[] range array element must the value of userInputToInt fall
            int userInputControlLoop=0;
            char randomLetter=characters[(int)(Math.random()*26)];
            // get the random input of computer convert it to int
            int computerInputToInt=0;

                //this loop is for getting the int value of randomLetter input by the computer
                for(int i=0;i<characters.length;++i)
                {
                    if(randomLetter==characters[i])
                    {

                        computerInputToInt=range[i];
                    }
                }
                //this loop is for getting the int value of user inputted letter
                for(char i:characters)
                {
                    if(enteredLetter==i)
                    {
                        userInputToInt=range[userInputControlLoop];
                    }
                    ++userInputControlLoop;
                }


                 //test the entered letter of user
            if(enteredLetter==randomLetter)
            {
                System.out.println("Correct Guess");
                System.out.println("The letter is:"+randomLetter);
            }
            //test the entered letter of user if greater than computer input
            else if(userInputToInt>computerInputToInt)
            {
                System.out.println("Incorrect Guess");
                System.out.println("The letter is too high");
                System.out.println("The letter is:"+randomLetter);
            }
            //test the entered letter of user if lesser than computer input
            else if(userInputToInt<computerInputToInt)
            {
                System.out.println("Incorrect Guess");
                System.out.println("The letter is too low");
                System.out.println("The letter is:"+randomLetter);
            }

        }