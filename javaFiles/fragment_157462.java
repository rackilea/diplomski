import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setTitle("DrawMatrix");
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new DrawPanel());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}

class DrawPanel extends JPanel {

    final static int DIST = 20;
    final static int MAX_ROW = 11;
    final static int MAX_COL = 11;
    int i = 1;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Points matrix
        int x = 0;
        for (int row = 1; row < MAX_ROW; row++) {
            x = row * DIST;
            for (int col = 1; col < MAX_COL; col++) {
                int y = col * DIST;
                g.setColor(Color.blue);
                g.drawLine(x, y, x, y + 1);
            }
        }
        g.drawLine(20, 20, 40, 40);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}