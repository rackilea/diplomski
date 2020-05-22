import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * @author Savvas Dalkitsis
 */
public class Test {

    public static void main(String[] args) {
        JFrame f = new JFrame("Test");
        JLabel l = new JLabel();
        ImageIcon io = new MirrorImageIcon("test.gif");
        l.setIcon(io);
        f.getContentPane().add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

}

@SuppressWarnings("serial")
class MirrorImageIcon extends ImageIcon {

    public MirrorImageIcon(String filename) {
        super(filename);
    }

    @Override
    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.translate(getIconWidth(), 0);
        g2.scale(-1, 1);
        super.paintIcon(c, g2, x, y);
    }

}