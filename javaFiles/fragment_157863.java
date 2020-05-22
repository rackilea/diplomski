import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

public class DrawStringUmlaut extends JPanel {
    public DrawStringUmlaut() {
        setPreferredSize(new Dimension(getPreferredSize().width, 200));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("\u00f6", 10, 20);
        g.drawString("\u00df", 40, 20);
        g.drawString(g.getFont().getFontName(), 10, 40);
        g.drawString(Integer.toString(g.getFont().getSize()) + " pt", 10, 60);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new DrawStringUmlaut(), BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}