import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Checkers {

    public static void main(String[] args) {
        new Checkers();
    }

    private JPanel[] cells;

    public Checkers() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(8, 8));

                cells = new JPanel[8 * 8];
                int col = 0;
                int counter = 0;
                for (int index = 0; index < cells.length; index++) {

                    JPanel panel = new JPanel(new BorderLayout());
                    cells[index] = panel;
                    panel.setPreferredSize(new Dimension(40, 40));
                    panel.setMinimumSize(panel.getPreferredSize());
                    if (counter % 2 == 0) {
                        panel.setBackground(Color.BLACK);
                    } else {
                        panel.setBackground(Color.WHITE);
                    }

                    frame.add(panel);

                    counter++;
                    col++;
                    if (col > 7) {
                        counter++;
                        col = 0;
                    }

                }

                int row = 3;
                col = 4;
                int cell = (row * 8) + col;

                cells[cell].add(new GamePiece(Color.RED));

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class GamePiece extends JPanel {

        public GamePiece(Color color) {
            setOpaque(false);
            setBackground(color);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int dim = Math.max(getWidth() - 4, getHeight() - 4);
            int x = (getWidth() - dim) / 2;
            int y = (getHeight() - dim) / 2;
            g2d.setColor(getBackground());
            g2d.fillOval(x, y, dim, dim);
            g2d.dispose();
        }

    }

}