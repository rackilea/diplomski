import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class MouseButtons extends JPanel {
    private static final int PREF_W = 800;
    private static final int PREF_H = 650;

    public MouseButtons() {
        MyMouseAdapter myMouse = new MyMouseAdapter();
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class MyMouseAdapter extends MouseAdapter {
        private boolean dragging = false;

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            String text = "";
            int button = e.getButton();
            if (button == MouseEvent.BUTTON1) {
                text = "Button 1";
            } else if (button == MouseEvent.BUTTON2) {
                text = "Button 2";
            } else if (button == MouseEvent.BUTTON3) {
                text = "Button 3";
            }

            if (dragging) {
                System.out.println(text + " just finished dragging");
            } else {
                System.out.println(text + " not recently dragging");
            }
            dragging = false;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            dragging = true;
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("MouseButtons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MouseButtons());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}