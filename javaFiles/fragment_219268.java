import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class DragLabelEg {
    private static final String[] LABEL_STRINGS = { "Do", "Re", "Me", "Fa",
            "So", "La", "Ti" };
    private static final int HEIGHT = 400;
    private static final int WIDTH = 600;
    private static final Dimension MAIN_PANEL_SIZE = new Dimension(WIDTH,
            HEIGHT);
    private static final int LBL_WIDTH = 60;
    private static final int LBL_HEIGHT = 40;
    private static final Dimension LABEL_SIZE = new Dimension(LBL_WIDTH,
            LBL_HEIGHT);
    private JPanel mainPanel = new JPanel();
    private Random random = new Random();

    public DragLabelEg() {
        mainPanel.setPreferredSize(MAIN_PANEL_SIZE);
        mainPanel.setLayout(null);

        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
        for (int i = 0; i < LABEL_STRINGS.length; i++) {
            JLabel label = new JLabel(LABEL_STRINGS[i], SwingConstants.CENTER);
            label.setSize(LABEL_SIZE);
            label.setOpaque(true);
            label.setLocation(random.nextInt(WIDTH - LBL_WIDTH),
                    random.nextInt(HEIGHT - LBL_HEIGHT));
            label.setBackground(new Color(150 + random.nextInt(105),
                    150 + random.nextInt(105), 150 + random.nextInt(105)));
            label.addMouseListener(myMouseAdapter);
            label.addMouseMotionListener(myMouseAdapter);

            mainPanel.add(label);
        }
    }

    public JComponent getMainPanel() {
        return mainPanel;
    }

    private class MyMouseAdapter extends MouseAdapter {
        private Point initLabelLocation = null;
        private Point initMouseLocationOnScreen = null;

        @Override
        public void mousePressed(MouseEvent e) {
            JLabel label = (JLabel)e.getSource();
            // get label's initial location relative to its container
            initLabelLocation = label.getLocation();

            // get Mouse's initial location relative to the screen 
            initMouseLocationOnScreen = e.getLocationOnScreen();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            initLabelLocation = null;
            initMouseLocationOnScreen = null;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // if not dragging a JLabel
            if (initLabelLocation == null || initMouseLocationOnScreen == null) {
                return;
            }
            JLabel label = (JLabel)e.getSource();

            // get mouse's new location relative to the screen
            Point mouseLocation = e.getLocationOnScreen();

            // and see how this differs from the initial location.
            int deltaX = mouseLocation.x - initMouseLocationOnScreen.x;
            int deltaY = mouseLocation.y - initMouseLocationOnScreen.y;

            // change label's position by the same difference, the "delta" vector
            int labelX = initLabelLocation.x + deltaX;
            int labelY = initLabelLocation.y + deltaY;

            label.setLocation(labelX, labelY);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGui();
            }
        });
    }

    private static void createGui() {
        JFrame frame = new JFrame("App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DragLabelEg().getMainPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}