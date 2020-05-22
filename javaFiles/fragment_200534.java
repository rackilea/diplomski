import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @see https://stackoverflow.com/a/36714997/230513
 */
public class Go {

    private Game game = Game.Easy;
    private final JComboBox gameCombo = new JComboBox();

    enum Game {

        Easy(9), Fast(13), Classic(17), Full(19);
        private int size;
        private String name;

        private Game(int size) {
            this.size = size;
            this.name = this.name() + ": " + size + "\u00d7" + size;
        }

        public int size() {
            return this.size;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel board = new JPanel() {
            @Override
            public Color getBackground() {
                return Color.cyan.darker();
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        };
        board.add(new JLabel(game.toString()));
        f.add(board);
        JPanel p = new JPanel();
        for (Game g : Game.values()) {
            gameCombo.addItem(g);
        }
        gameCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game = (Game) gameCombo.getSelectedItem();
                board.removeAll();
                board.add(new JLabel(game.toString()));
                board.validate();
                board.repaint();
            }
        });
        p.add(new JButton("Start"));
        p.add(gameCombo, BorderLayout.SOUTH);
        f.add(p, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Go()::display);
    }
}