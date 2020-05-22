package boardgame;

import static boardgame.ArrayToString.convertToString;

public class Testing {
    public static void main(String[] args) {

        //create an empty playfield that is 10x10
        Board emptyBoard = new Board(10, 10);

        //convert playfield to string and save it in new variable
        String newBoard = convertToString(emptyBoard); 

        //now show the playfield as a string
        System.out.println(newBoard);
    }
}