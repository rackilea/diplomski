import java.awt.Dimension;

import javax.swing.*;

public class Game extends JFrame {
    private static final long serialVersionUID = -7919358146481096788L;
    JPanel a = new JPanel();
    public static void main(String[] args) {
        new Game();
    }
    private Game() {
        setTitle("Insert name of game here");
        setLocationRelativeTo(null);
        //setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        a.setPreferredSize(new Dimension(600, 600));
        add(a);
        pack();
        setVisible(true);
    }
}