package com.sandbox;

import java.util.Random;
import java.util.Scanner;

public class Sandbox {

    /**
     * (Insert a brief description that describes the purpose of this method)
     *
     * @param args
     */
    public static void main(String[] args) {
        int compint;
        String usermove = "";
        String compmove = "";
        String winner = "";
        int count = 0;
        String rawInput = null;
        int input = 0;


        Scanner in = new Scanner(System.in);
        Random gen = new Random();

        System.out.print("Enter Rock(1), Paper(2), Scissors(3) {Q to quit]: ");
        rawInput = in.next();
        if ("Q".equals(rawInput)) {
            return;     //exit main
        }
        input = Integer.parseInt(rawInput);

        while (count < 3) {
            compint = gen.nextInt(3) + 1;

            if (input == 1) {
                usermove = "Rock";
            } else if (input == 2) {
                usermove = "Paper";
            } else if (input == 3) {
                usermove = "Scissors";
            }

            if (compint == 1) {
                compmove = "Rock";
            } else if (compint == 2) {
                compmove = "Paper";
            } else if (compint == 3) {
                compmove = "Scissors";
            }

            if (compint == input) {
                winner = "TIE";
            } else if (compint == 1 && input == 3) {
                winner = "COMPUTER";
            } else if (compint == 2 && input == 1) {
                winner = "COMPUTER";
            } else if (compint == 3 && input == 2) {
                winner = "COMPUTER";
            } else {
                winner = "USER";
            }

            System.out.print("Computer: " + compmove + " | ");
            System.out.print("You: " + usermove + " | ");
            System.out.println("Winner: " + winner);
            System.out.println();
            count++;
            System.out.print("Enter Rock(1), Paper(2), Scissors(3) {Q to quit]: ");
            input = in.nextInt();


        }
    }
}