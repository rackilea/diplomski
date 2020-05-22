import java.util.*;         
import java.util.Scanner;   
import java.util.Random;     
public class Game       
{                           
    public static void main (String[] args){     

        int NumberofRoundsPlayed;        
        int NumberofRoundsWonbyHuman = 0;   

        Scanner Keyboard = new Scanner (System.in);      

        System.out.println("DO YOU WANT TO PLAY ROCK PAPER SCISSORS- Y/N");                       
        String HumanPlaying  = Keyboard.nextLine();


        if(HumanPlaying.equals("No"))
        {
            System.out.println("Game Over");
            System.exit(0);
        }



        int Paper = 1;  
        int Scissor = 2;    
        int Rock  = 3;      

        int HumanSelection;
        int humanroundsWon =0;

        System.out.println("HOW MANY ROUNDS DO YOU WANT TO PLAY");
        NumberofRoundsPlayed = Keyboard.nextInt();      

        while  (NumberofRoundsPlayed < NumberofRoundsPlayed++)  
        {
            Scanner Computer = new Scanner (System.in);
            Random rand = new Random();

            int ComputerChoice =Computer.nextInt()+1; 
            System.out.println(ComputerChoice);

            System.out.println("Select 1 for Paper, 2 for Scissor or 3 for Rock");                    
            HumanSelection = Keyboard.nextInt();

            //SEE WHO WINS

            if (ComputerChoice== 1)
            {
                if (HumanSelection==1)
                {
                    System.out.println("Computer and Human Have Tied");
                }
                else if (HumanSelection==2)
                {
                    System.out.println("Person Wins");
                    humanroundsWon++;
                }
                else if (HumanSelection==3)
                {
                    System.out.println("Computer Wins");
                }
            }
                else if (ComputerChoice==2)
                {
                    if (HumanSelection==1)
                    {
                        System.out.println("computer Wins");

                    }
                    else if (HumanSelection==2)
                    {
                        System.out.println("Computer and Person Have Tied");
                    }
                    else if (HumanSelection==3)
                    {
                        System.out.println("Person Wins");
                        humanroundsWon++;

                    }
                }

                else if (ComputerChoice==3)
                {


                    if (HumanSelection==1)
                    {
                        System.out.println("Person Wins");
                        humanroundsWon++;
                    }

                    else if (HumanSelection==2)
                    {
                        System.out.println("Computer Wins");
                    }

                    else if (HumanSelection==3)
                    {
                        System.out.println("Tie");  

                    }
                }

            }

        System.out.println("Game Over");
        System.exit(0);
        }
    }