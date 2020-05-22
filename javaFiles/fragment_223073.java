import java.awt.Frame;
import java.awt.Graphics;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;

public class Test extends Frame {
    ImageIcon a;

    WindowListener wl = new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    };

    public Test() {
        a = new ImageIcon("myImage.jpg");
        setSize(a.getIconWidth(), a.getIconHeight());
        setLocationRelativeTo(null);
        addWindowListener(wl);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(a.getImage(), 0, 0, this);
    }

    public static void main(String[] args) {
        Test myTest = new Test();
    }
}