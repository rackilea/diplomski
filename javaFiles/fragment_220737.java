import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @see http://stackoverflow.com/a/37150783/230513
 */
public class Test {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setFont(getFont().deriveFont(Font.BOLD, 24f));
                String s = "2D Shooter";
                int w2 = g.getFontMetrics().stringWidth(s) / 2;
                int h2 = g.getFontMetrics().getHeight();
                g.drawString(s, getWidth() / 2 - w2, h2);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        });
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test()::display);
    }
}