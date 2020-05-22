import java.awt.*;
import javax.swing.*;

public class Test {
    public static void main(String args[]) {
        JFrame myapp = new JFrame("test");
        myapp.setLayout(new FlowLayout());

        myapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myapp.getContentPane().add(Board());

        // very important!
        myapp.pack();

        // do these last.
        myapp.setSize(400,400);
        myapp.setVisible(true);

    }

    private static JPanel Board() {
        JButton[][] buttons = new JButton [10][10];
        for(int x=0; x<buttons.length; x++) {
            for (int y=0; y<buttons[0].length; y++) {
                buttons[x][y] = new JButton();
            }
        }

        JPanel board = new JPanel(new GridLayout(11,11));

        String[] rowlabels = {" ","A","B","C","D","E","F","G","H","I","J"};
        String[] columnlabels = {" ","1","2","3","4","5","6","7","8","9","10"};
        JTextField k;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if ((j != 0) && (i != 0)) {
                    //myboard[i-1][j-1].addActionListener(new ButtonHandler());
                    board.add(buttons[i-1][j-1]);
                }
                if (i == 0) {
                    if (j != 0) {
                        // used to display row of numbers
                        k = new JTextField(columnlabels[j]);
                        k.setEditable(false);
                        k.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
                    } else {
                        // used to display column of numbers
                        k = new JTextField();
                        k.setEditable(false);
                    }
                    board.add(k);
                } else if (j == 0) {
                    k = new JTextField(rowlabels[i]);
                    k.setEditable(false);
                    k.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
                    board.add(k);
                }
            }
        }

        return board;
    }
}