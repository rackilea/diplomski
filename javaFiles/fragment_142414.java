import java.util.*;
import java.util.Scanner;
import java.util.Arrays;

public class BattleshipsButBetter {

    static Scanner in = new Scanner(System.in);
    public static boolean hideShip = true; //Make the ship hidden or not for testing
    private static FireResult fr = new FireResult();

    public static void main(String[] args)
    {
        do
        {
            System.out.println("Privet, comrade.");
            System.out.println("Welcome to modified battleship program!");


            String[][] board = new String[8][8];
            createBoard(board);
            createShip(board, 4);

            int torpedoes = 0;
            int hits = 0;
            int difficulty = getDifficulty();

            if(difficulty == 1)
            {
                torpedoes = 15;
            }
            else if(difficulty == 2)
            {
                torpedoes = 10;
            }
            else
            {
                torpedoes = 5;
            }

            System.out.println("You have only " + torpedoes + " torpedoes to sink the ship... good luck!");

            while(torpedoes > 0 && hits < 4)
            {
                showBoard(board);
                fire(board, hits, torpedoes);
                // Get results from FireResult static class
                hits = fr.hits;
                torpedoes = fr.torpedoes;

                // Original logic continues
                torpedoes--;
            }
            results(hits, torpedoes);
        }while(repeat());
    }

    public static int getDifficulty()
    {
        System.out.println("Select a difficulty: \n 1. Normal \n 2. Hard \n 3 or any other number = impossible!");
        return in.nextInt();
    }

    public static void createBoard(String[][] board)
    {
        for(int x = 0; x < board.length; x++)
            for(int y = 0; y < board[0].length; y++)
                board[x][y] = "~";
    }

    public static void showBoard(String[][] board)
    {
        System.out.println();
        System.out.println("  1 2 3 4 5 6 7 8");
        for(int x = 0; x < board.length; x++)
        {
            if(hideShip == false)
            {
                System.out.print(x + 1);
                for(int y = 0; y < board[0].length; y++)
                {
                    System.out.print(" " + board[x][y]);
                }
                System.out.println("");
            }
            else
            {
                System.out.print(x + 1);
                for(int y = 0; y < board[0].length; y++)
                {
                    if(board[x][y].equals("S"))
                    {
                        System.out.print(" " + "~");
                    }
                    else
                    {
                        System.out.print(" " + board[x][y]);
                    }
                }
                System.out.println("");
            }
        }
        System.out.println();
    }

    public static void createShip(String[][] board, int size)
    {
        if(Math.random() < 0.5)
        {
            int col = (int)(Math.random()*5);
            int row = (int)(Math.random()*7);
            for(int i = 0; i < size; i++)
            {
                board[row][col+i] = "S";
            }
        }
        else
        {
            int col = (int)(Math.random()*7);
            int row = (int)(Math.random()*5);
            for(int i = 0; i < size; i++)
            {
                board[row+i][col] = "S";
            }
        }
    }

    public static void fire(String[][] board, int hits, int torpedoes)
    {
        int row = 0, col = 0;
        System.out.println("You have " + torpedoes + " torpedoes left...");
        System.out.println("Select a row to fire in: ");
        row = in.nextInt();
        while(row > 8 || row < 1)
        {
            System.out.println("Enter a valid row (1 - 8) and try again...");
            row = in.nextInt();
        }
        System.out.println("Select a column to fire in: ");
        col = in.nextInt();
        while(col > 8 || col < 1)
        {
            System.out.println("Enter a valid column (1 - 8) and try again...");
            col = in.nextInt();
        }

        if(board[row-1][col-1].equals("X") || board[row-1][col-1].equals("M"))
        {
            torpedoes++;
        }
        else if(board[row-1][col-1].equals("S"))
        {
            hits++;
            System.out.println("Hit!");
            board[row-1][col-1] = "X";
        }
        else
        {
            System.out.println("Miss!");
            board[row-1][col-1] = "M";
        }

        fr.hits = hits;
        fr.torpedoes = torpedoes;
    }

    public static void results(int hits, int torpedoes)
    {
        if(hits < 4)
            System.out.println("Sorry, you didn't sink the ship :(");
        if(torpedoes < 1)
            System.out.println("You have lost all of your torpedoes!");
        else
        if(hits >= 4)
        {
            System.out.println("Congratulations, comrade, you sank the ship. GG WP!");
        }
    }

    public static boolean repeat()
    {
        int repeat;
        System.out.println();
        Scanner in = new Scanner(System.in);
        do
        {
            System.out.println("Would you like to play again? 1. YES, 2. NO");
            repeat = in.nextInt();
            if(repeat < 1 || repeat > 2)
            {
                System.out.println(repeat + " is not a valid entry.");
            }
        }
        while(repeat < 1 || repeat > 2);
        System.out.println();
        return repeat == 1;
    }

    public static class FireResult {
        int hits;
        int torpedoes;
    }
}