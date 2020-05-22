import java.awt.*;
import java.awt.Event;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class DragNDropper implements MouseMotionListener, MouseListener {

    private int x, y;
    private int dx, dy; 
    private boolean clicked;    
    private JFrame jf;

    public static void main(String[] argv) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DragNDropper().displayGUI();
            }
        });
    }

    private void displayGUI() {
        dx = dy = 0;
        jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setUndecorated(true);

        jf.setSize(new Dimension(512, 512));
        jf.addMouseListener(this);
        jf.addMouseMotionListener(this);

        jf.setVisible(true);
    }

    public void mouseDragged(MouseEvent e) {
        x = e.getXOnScreen();
        y = e.getYOnScreen();
        jf.setLocation(x-dx, y-dy);
    }

    public void mouseMoved(MouseEvent e) {
        x = e.getXOnScreen();
        y = e.getYOnScreen();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        clicked = true;
        dx = e.getX();
        dy = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        clicked = false;
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered");
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited");
    }
}