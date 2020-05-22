import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class Base extends JPanel implements MouseMotionListener {

    public static void main(String[] args) {
        new Base();
    }

    final static int width = 400;
    final static int height = 300;
    BufferedImage img;
    Base() {

        img = new BufferedImage(width, height, 
            BufferedImage.TYPE_INT_ARGB_PRE);
        // do in preference to setting the frame size..
        setPreferredSize(new Dimension(width, height));
        JFrame frame = new JFrame();
        this.addMouseMotionListener(this); // INSTEAD OF THE FRAME
        frame.add(this);
        //frame.setSize(width, height);  DO INSTEAD...
        frame.pack();
        //frame.setEnabled(true);  REDUNDANT
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // good call!
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Graphics g = img.getGraphics();
        g.setColor(Color.RED);  // SET A COLOR
        g.drawRect(1, 1, width - 2, height - 2);

        // DO SOMETHING UGLY
        g.setColor(Color.blue);
        Point p = e.getPoint();
        g.fillOval(p.x,p.y,5,5);

        g.dispose();
        repaint();
    }
    @Override
    public void paintComponent(Graphics g) {
         g.drawImage(img, 0, 0, null);
    }
}