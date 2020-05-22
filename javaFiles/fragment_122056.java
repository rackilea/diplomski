import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class game {
    JFrame frame;
    JButton grids[][] = new JButton[9][9];

    public game() {
        make();
        JPanel p = new JPanel();
        JButton resetButton = new JButton("reset");
        JButton playButton = new JButton("Play");
        p.add(playButton);
        p.add(resetButton);
        frame.add(p,BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void make() {
        frame = new JFrame("Gamer");
        frame.setTitle("Gamer");
        JPanel m = new JPanel(new GridLayout(9, 9));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grids[i][j] = new JButton();
                m.add(grids[i][j]);
            }
        }
        frame.add(m, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        game gameObj = new game();
    }
}