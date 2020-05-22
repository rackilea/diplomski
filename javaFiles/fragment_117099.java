import java.awt.*;
import javax.swing.*;
public class TheJFrame {
public static final char[][] board = new char[17][17];
public static class TheJFramez {
    JFrame boardz = new JFrame("Game of Life");
    JPanel panel = new JPanel();
    public TheJFramez(){
        int r = 0,c;
        boardz.setLayout(new GridLayout(board.length,board[r].length));
        for(r=0;r<17;r++){
            for(c = 0;c<17;c++){
                JButton tats = new JButton(" " + board[r][c] + " ");
                boardz.add(tats);
                System.out.print(board[r][c]);
            }
            System.out.println();
        }

        boardz.setVisible(true);
        boardz.setSize(1200, 700);
        boardz.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
public static void main(String[] args) {
    new TheJFramez();
}
}