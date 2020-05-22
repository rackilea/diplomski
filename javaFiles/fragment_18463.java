package ratsuk;

import java.util.Random;
import javax.swing.JFrame;

public class Ratsuk extends JFrame {

    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        Random random= new Random();
        int row= random.nextInt(8);
        int column = random.nextInt(8);

        Tablero table= new Tablero();
        table.caballo(row, column);
    }
}