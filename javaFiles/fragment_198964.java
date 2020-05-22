import java.awt.DisplayMode;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        JFrame f = new JFrame("Test");
        f.setUndecorated(true);
        f.add(new TestPane());
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsDevice device = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (device.isFullScreenSupported()) {
            device.setFullScreenWindow(f);
            if (device.isDisplayChangeSupported()) {
                try {
                    List<DisplayMode> matchingModes = new ArrayList<>(25);

                    DisplayMode[] modes = device.getDisplayModes();
                    for (DisplayMode mode : modes) {
                        if (mode.getWidth() == 1280 && mode.getHeight() == 720) {
                            matchingModes.add(mode);
                        }
                    }

                    if (!matchingModes.isEmpty()) {
                        for (DisplayMode mode : matchingModes) {
                            try {
                                device.setDisplayMode(mode);
                                System.out.println(mode.getWidth() + "x" + mode.getHeight() + " " + mode.getBitDepth() + " @ " + mode.getRefreshRate());
                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        System.err.println("!! No matching modes available");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("Change display mode not supported");
            }
        } else {
            System.err.println("Full screen not supported");
        }
    }

    public static class TestPane extends JPanel {

        private boolean spaced = false;

        public TestPane() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    requestFocusInWindow(true);
                    if (e.getClickCount() == 2) {
                        SwingUtilities.windowForComponent(TestPane.this).dispose();
                    }
                }
            });

            InputMap im = getInputMap();
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), "spaced-pressed");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "spaced-released");
            am.put("spaced-pressed", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    spaced = true;
                    repaint();
                }
            });
            am.put("spaced-released", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    spaced = false;
                    repaint();
                }
            });

            requestFocusInWindow(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            String text = getWidth() + "x" + getHeight();
            FontMetrics fm = g.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(text)) / 2;
            int y = (getHeight() - fm.getHeight()) / 2;
            g.drawString(text, x, y + fm.getAscent());

            GraphicsDevice device = GraphicsEnvironment
                    .getLocalGraphicsEnvironment().getDefaultScreenDevice();

            DisplayMode mode = device.getDisplayMode();
            text = mode.getWidth() + "x" + mode.getHeight() + " " + mode.getBitDepth() + " @ " + mode.getRefreshRate();
            x = (getWidth() - fm.stringWidth(text)) / 2;
            y += fm.getHeight();
            g.drawString(text, x, y + fm.getAscent());

            text = "Spaced [" + spaced + "]";
            x = (getWidth() - fm.stringWidth(text)) / 2;
            y += fm.getHeight();
            g.drawString(text, x, y + fm.getAscent());
        }

    }
}