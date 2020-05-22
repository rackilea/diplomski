package com.test;

import javax.swing.JOptionPane;

public class Test1 {

    public static void main(String[] args) {

        final int MIN_NUM = 1;
        final int MAX_NUM = 5;
        int count = 0;

        int[] guesses = getUserGuess();

        int randomNum = getRandomNum(MIN_NUM, MAX_NUM);

        for (int i = 0; i < guesses.length; i++) {
            boolean determineMatch = isGuessCorrect(randomNum, guesses[i]);
            if (determineMatch == true) {
                count++;
            }
        }
        displayResult(count);

    }

    public static int getRandomNum(int MIN_NUM, int MAX_NUM) {
        return (int) (Math.random() * MAX_NUM) + MIN_NUM;
    }

    public static int[] getUserGuess() {

        final int MIN_GUESS = 1;
        final int MAX_GUESS = 5;

        int[] guess = new int[MAX_GUESS];

        for (int i = 0; i < guess.length; i++) {
            do {
                try {
                    guess[i] = Integer
                            .parseInt(JOptionPane
                                    .showInputDialog("Enter a number between 1 and 5:"));
                }

                catch (NumberFormatException e) {
                    guess[i] = 0;
                }

                if (guess[i] < MIN_GUESS || guess[i] > MAX_GUESS) {
                    JOptionPane.showMessageDialog(null,
                            "ERROR! Enter a number between 1 and 5");
                }

            } while (guess[i] < MIN_GUESS || guess[i] > MAX_GUESS);

        }

        return guess;

    }

    public static boolean isGuessCorrect(int randomNum, int guess) {

        boolean determineMatch = true;

        if (randomNum == guess) {
            determineMatch = true;
        } else {
            determineMatch = false;
        }

        return determineMatch;

    }

    public static void displayResult(int count) {

        if (count >= 0 || count <= 1) {
            JOptionPane
                    .showMessageDialog(
                            null,
                            "Out of 5 tries, you guessed "
                                    + count
                                    + " correct.\nYou don’t have any supernatural powers. Sorry!");
        } else if (count >= 2 || count <= 3) {
            JOptionPane.showMessageDialog(null, "Out of 5 tries, you guessed "
                    + count
                    + " correct.\nYou might be good. Try again another time.");
        } else if (count >= 4 || count <= 5) {
            JOptionPane.showMessageDialog(null, "Out of 5 tries, you guessed "
                    + count + " correct.\nYou’re hired! When can you start?");
        }

    }

}