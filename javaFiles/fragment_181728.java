// Filename: Lottery.java
// Written by: Andy A
// Written on: 14 January 2015

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Lottery {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        Random ranNum = new Random();

        // LIMIT Contains The Numbers From 0 - 9
        // TIMES Contains The Number of Time ranNum Should Run
        final int LIMIT = 9;
        final int TIMES = 3;

        // Users Guesses
        int usersFirstGuess;
        int usersSecondGuess;
        int usersThirdGuess;
        List<Integer> guesses = new ArrayList<>();

        // Randomly Generated Numbers
        final int GenFirst = ranNum.nextInt(LIMIT);
        final int GenSecond = ranNum.nextInt(LIMIT);
        final int GenThird = ranNum.nextInt(LIMIT);

        // User is asked for 3 guesses
        System.out.println("Please enter your first guess: ");
        usersFirstGuess = userInput.nextInt();
        guesses.add(usersFirstGuess);
        System.out.println("Please enter your second guess: ");
        usersSecondGuess = userInput.nextInt();
        guesses.add(usersSecondGuess);
        System.out.println("Please enter your third and final guess: ");
        usersThirdGuess = userInput.nextInt();
        guesses.add(usersThirdGuess);

        // Winning Amounts
        final double WinTen = 10;
        final double WinHun = 100;
        final double WinThund = 1000;
        final double WinMillion = 1000000;
        final int WinZero = 0;

        // Shows the randomly generated numbers
        System.out.println(GenFirst + " " + GenSecond + " " + GenThird);
        List<Integer> lottery = new ArrayList<>();
        lottery.add(GenFirst);
        lottery.add(GenSecond);
        lottery.add(GenThird);

        if (guesses.equals(lottery)) {
            System.out.println("You have won: $" + WinMillion);
        } else {
            int matchCount = 0;
            for (Integer guessValue : guesses) {
                if (lottery.contains(guessValue)) {
                    matchCount++;
                    lottery.remove(guessValue);
                }
            }

            switch (matchCount) {
                case 0:
                    System.out.println("You have won: $" + WinZero);
                    break;
                case 1:
                    System.out.println("You have won: $" + WinTen);
                    break;
                case 2:
                    System.out.println("You have won: $" + WinHun);
                    break;
                case 3:
                    System.out.println("You have won: $" + WinThund);
                    break;
            }
        }
    }
}