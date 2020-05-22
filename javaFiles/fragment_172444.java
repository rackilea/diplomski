import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SSCCE {

    public static void getInputData(MouseEvent e) {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel("Test", JLabel.CENTER);
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        frame.setPreferredSize(new Dimension(375, 100));

        MouseAdapter ma = new MouseAdapter() {

            Point local, global;
            Point delta = new Point();

            @Override
            public void mousePressed(MouseEvent me) {
                local = me.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent me) {
                delta.setLocation(
                    me.getX() - local.x, me.getY() - local.y);
                global = frame.getLocationOnScreen();
                global.setLocation(
                    global.x + delta.x, global.y + delta.y);
                frame.setLocation(global.x, global.y);
            }
        };
        frame.getContentPane().addMouseListener(ma);
        frame.getContentPane().addMouseMotionListener(ma);
        frame.pack();
        frame.setLocation(e.getLocationOnScreen());
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(640, 480));
        frame.add(new JLabel("Click me", JLabel.CENTER));
        frame.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                getInputData(e);
            }
        });
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}