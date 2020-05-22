import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUI extends JFrame {

    private Board board;

    private GUI() {
        board = new Board();
        setLayout(new FlowLayout());
        add(board);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GUI();
            }
        });
    }

    class Board extends JPanel {

        public Field[][] fields = new Field[8][8];

        public Board() {
            setLayout(new GridLayout(8, 8));
            setMinimumSize(new Dimension(500, 500));
            setPreferredSize(new Dimension(550, 550));
            setBackground(Color.RED);
            fillBoard();
        }

        private void fillBoard() {
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    fields[i][j] = new Field(i, j);
                    add(fields[i][j]);
                }
            }
        }
    }

    class Field extends JLabel {

        private int x, y;

        public Field(int x, int y) {
            this.x = x;
            this.y = y;
            setOpaque(true);
            setMinimumSize(new Dimension(50, 50));
            setPreferredSize(new Dimension(75, 75));
            if ((x + y) % 2 == 0) {
                setBackground(Color.GREEN);
            } else {
                setBackground(Color.YELLOW);
            }
        }
    }
}