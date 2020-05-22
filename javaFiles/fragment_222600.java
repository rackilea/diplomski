package gameOfLife;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class gameOfLife {
    public static void main(String[] args) throws Exception {
        File input = new File("gameBoardInput.txt");
        Scanner reader = new Scanner(input);
        int y = reader.nextInt();
        int x = reader.nextInt();

        Grid grid = new Grid(x, y);

        for (int i = 0; i < x; i++) {
            String cupcake = reader.nextLine();
            while (cupcake.isEmpty())
                cupcake = reader.nextLine();
            char[] muffin = cupcake.toCharArray();
            for (int j = 0; j < y; j++) {
                grid.setAt(i, j, muffin[j]);
            }
        }
    }
}