import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;

public class AAComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Maybe you want to skip this, up to your needs...

        Graphics2D g2 = null;
        try {
            g2 = (Graphics2D) g.create();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Your painting procedures
        } finally {
            if (g2 != null) {
                g2.dispose();
            }
        }
    }

}