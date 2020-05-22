import java.util.*;

public class GuessNumber
{
    public static void main(String[] args) 
    {
        // TODO Auto-generated method stub
        Scanner keyboard = new Scanner(System.in);
        Random myRand = new Random();
        ArrayList<Player> players = new ArrayList<Player>();
        int x = 0;
        System.out.println("how many players are there?:");
        int noPlayer = checkint();
        boolean validGuess = true , playError = true;

        for (int i = 0; i<noPlayer; i++) 
        {
            System.out.println("New player, what is your name?:");
            players.add(new Player (keyboard.nextLine()));
        }


        for (int i = 0; i<noPlayer; i++) 
        {
            players.get(i).number = myRand.nextInt(100) + 1;
        }
        int i =0; // for chossing different player each time
        do 
        {
            System.out.printf(players.get(i).name + " enter what you think the number is between 0 and 100!: ");
            x= checkint();
            players.get(i).guessedNumbers.add(x);
            players.get(i).numOfGuesses++;
            if (x == players.get(i).number) 
            {
                System.out.println("That's correct!");
                System.out.println("It took you " + players.get(i).numOfGuesses + " tries!");
                System.out.print("These are all the numbers you guessed: ");
                System.out.println(players.get(i).guessedNumbers);

                do 
                {
                    System.out.println("Would you like to play again: Yes or No");
                    String answer = keyboard.nextLine();
                    if (answer.compareToIgnoreCase("yes") == 0)
                    {
                        playError = false;
                        players.get(i).number = myRand.nextInt(100) + 1; // creates a new random number for second round of the game
                        System.out.println("\n\n************ " +players.get(i).name + " WON ********");
                        System.out.println("\n************* SECOND ROUND STARTS **********");
                    }
                    else if (answer.compareToIgnoreCase("no") == 0)  
                    {
                        playError = false;
                        System.out.println("Thank you for playing");
                        System.out.println("\n\n************ " +players.get(i).name + " WON ********");
                        System.out.println("\n************* SECOND ROUND STARTS **********");
                        players.remove(i);
                    } 
                    else 
                    {
                        System.out.println("You answer was invalid");
                        playError = true;
                    }
                } while (playError);
            }
            else if (x>players.get(i).number) 
                System.out.println("Lower than that!");
            else if (x<players.get(i).number) 
                System.out.println("Higher than that!");
            if(i == noPlayer-1 || !(playError))
                i = 0;
            else
                i++;

        }while (players.size() > 0);  

        System.out.println("\n\n******************** Every Body Guessed Their Numbers ******************");
    }

    static int checkint() 
    {
        int enteredNumber = 0;
        Scanner myScanner = new Scanner(System.in);
        boolean numberError = false;

        do 
        {
            try 
            {
                enteredNumber = Integer.parseInt(myScanner.next().trim()); 
                if (enteredNumber < 0 || enteredNumber > 100)
                {
                    System.out.println("Either you entered a negative number or number is above the random number generator range");
                    numberError =  true;
                }
                else
                    numberError = false;  //if we haven't bailed out, then the number must be valid.
            } catch(Exception e) 
            {
                System.out.println("Your entry is invalid...Please try again");
                numberError = true;  //Uh-Oh...We have a problem.
            }

        } while (numberError);  //Keep asking the user until the correct number is entered.

        return enteredNumber;  
    }
}

// now each player would have its own record.
class Player
{
    int numOfGuesses= 0;
    ArrayList<Integer> guessedNumbers = new ArrayList<Integer>();
    String name = "";
    int number = 0;
    public Player(String nam)
    {
        name = nam;
    }
}