import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class Player

{
    String player = "X";
    String cpu = "O";

    int row = 3;
    int column = 3;

    private Board ticTac;


    public static Scanner scan = new Scanner(System.in);
    public Player(Board board, String inBoard )
    {
        //here you have the board in player
        tictac = board;
    }

    public void computerMove()
    {   //here you can code something like this
        tictac.put(tictac.getRandomFreePlace(),cpu);
    }        

    public void humanMove(Position position)
    {
        tictac.put(position, human);
    }
}