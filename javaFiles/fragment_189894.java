import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe{

    private static Scanner scan = new Scanner(System.in);

    public static void main (String[] args){

        boolean finished = false;
        int plays = 0;
        int position = 0;
        ArrayList<Integer> alreadyPlayed = new ArrayList<>();
        String[] board = {"_","_","_","_","_","_","_","_","_"};
        String character;

        do{
            character = plays % 2 == 0 ? "x" : "o";
            do{
            System.out.println("Player " + character + ", it's your turn. (0-8)");
            System.out.println("Already played :" + alreadyPlayed.toString());
            position = scan.nextInt();
            } while (position >= 9 || alreadyPlayed.contains(position));
            alreadyPlayed.add(position);
            board[position] = character;
            if (alreadyPlayed.size()>=5){
                finished = checkFinished(board);
            }
            plays++;

            for (int i = 0 ; i < 9 ; i++){
                System.out.print(board[i]);
                if ((i+1) % 3 == 0) System.out.println();
            }

        } while (!finished && plays < 9);
        if (checkFinished(board)) System.out.println("Players " + character + " wins !");
        else System.out.println("No one wins.");


    }

    private static boolean checkFinished(String[] toCheck) {
        // Horizontal checks
        if (!toCheck[0].equals("_") && toCheck[0].equals(toCheck[1]) && toCheck[0].equals(toCheck[2])) return true;
        if (!toCheck[3].equals("_") && toCheck[3].equals(toCheck[4]) && toCheck[3].equals(toCheck[5])) return true;
        if (!toCheck[6].equals("_") && toCheck[6].equals(toCheck[7]) && toCheck[6].equals(toCheck[8])) return true;

        // Vertical checks
        if (!toCheck[0].equals("_") && toCheck[0].equals(toCheck[3]) && toCheck[0].equals(toCheck[6])) return true;
        if (!toCheck[1].equals("_") && toCheck[1].equals(toCheck[4]) && toCheck[1].equals(toCheck[7])) return true;
        if (!toCheck[2].equals("_") && toCheck[2].equals(toCheck[5]) && toCheck[2].equals(toCheck[8])) return true;

        // Diagonal checks
        if (!toCheck[0].equals("_") && toCheck[0].equals(toCheck[4]) && toCheck[0].equals(toCheck[8])) return true;
        if (!toCheck[2].equals("_") && toCheck[2].equals(toCheck[4]) && toCheck[2].equals(toCheck[6])) return true;
        return false;
    }
}