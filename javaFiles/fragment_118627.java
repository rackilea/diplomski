package gessinggame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GessingGame {

    public static void main(String[] args) {




//<editor-fold desc="Start Variables and Objects">

        Random random = new Random();
        Scanner input = new Scanner(System.in);

        int counter = 0;
        int numberOfUser = 0;
        int guessNumber = 0;
        int x = 1;
        System.out.print("Try to guess my number! What should be the highest number I can go up to?: ");
        do{
        try{
            numberOfUser = input.nextInt();
            guessNumber = random.nextInt(numberOfUser);
            x = 2;
        }catch(Exception e)
        {
            System.out.print("That doesn't work! Please enter an integer higher than 0 :");
            input.nextLine();
            x = 1;
        }
        }while(x == 1);


        System.out.println("Try to guess my number! Its from 0 to " + numberOfUser + " !");
        System.out.println("---------------------------------------------------");

        do{

                int userguess = input.nextInt();

                    if(userguess > numberOfUser)
                    {
                    System.out.println("Oh man, at the beginning you said that the highest number is: " + numberOfUser);
                    }
                    else{       
                            if(userguess < 0)
                            {
                            System.out.println("My number is always taller than 0");
                            } else{  
                                    if(guessNumber < userguess)
                                    {
                                        System.out.println("lower");
                                        counter++;
                                    }
                                    if(guessNumber > userguess) 
                                    {
                                        System.out.println("higher");
                                        counter++;
                                    }
                                    if(userguess == guessNumber) 
                                    {
                                        counter++;
                                        break;
                                    }
                                    }
                        }
            }while(true);
        System.out.println("You guessed my number! My number was: " + guessNumber + "! You needed " + counter + " attempts!");
    }

}