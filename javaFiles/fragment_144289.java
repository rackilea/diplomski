import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @see https://stackoverflow.com/a/19531648/230513
 */
public class Test {

    private static class MyPanel extends JPanel {

        private static final int N = 8;
        private static final int TILE = 48;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(N * TILE, N * TILE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.gray);
            int w = this.getWidth();
            int h = this.getHeight();
            int tile = Math.min(w, h) / N;
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if ((row + col) % 2 == 0) {
                        g.fillRect(col * tile, row * tile, tile, tile);
                    }
                }
            }
        }
    }

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}