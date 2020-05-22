package mcve;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.net.*;
import java.io.*;

public class LargeCursor {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();

            JPanel glass = new CustomGlassPane();
            glass.add(new CursorPanel(), BorderLayout.CENTER);
            frame.setGlassPane(glass);
            // This next call is necessary because JFrame.setGlassPane delegates to the root pane:
            // - https://docs.oracle.com/javase/9/docs/api/javax/swing/RootPaneContainer.html#setGlassPane-java.awt.Component-
            // - http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/javax/swing/JFrame.java#l738
            // And JRootPane.setGlassPane may call setVisible(false):
            // - https://docs.oracle.com/javase/9/docs/api/javax/swing/JRootPane.html#setGlassPane-java.awt.Component-
            // - http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/javax/swing/JRootPane.java#l663
            glass.setVisible(true);

            JPanel content = createTestPanel();
            content.setCursor(BlankCursor.INSTANCE);

            frame.setContentPane(content);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    static class CustomGlassPane extends JPanel {
        CustomGlassPane() {
            super(new BorderLayout());
            super.setOpaque(false);
        }
        @Override
        public boolean contains(int x, int y) {
            return false;
        }
    }

    static class CursorPanel extends JPanel {
        final BufferedImage cursorImage;
        Point mouseLocation;

        CursorPanel() {
            try {
                cursorImage = createTransparentImage(
                    ImageIO.read(new URL("https://i.stack.imgur.com/9h2oI.png")));
            } catch (IOException x) {
                throw new UncheckedIOException(x);
            }

            setOpaque(false);

            long mask = AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK;

            Toolkit.getDefaultToolkit().addAWTEventListener((AWTEvent e) -> {
                switch (e.getID()) {
                    case MouseEvent.MOUSE_ENTERED:
                    case MouseEvent.MOUSE_EXITED:
                    case MouseEvent.MOUSE_MOVED:
                    case MouseEvent.MOUSE_DRAGGED:
                        capturePoint((MouseEvent) e);
                        break;
                }
            }, mask);

            // This turned out to be necessary, because
            // the 'mouse exit' events don't always have
            // a Point location which is outside the pane.
            Timer timer = new Timer(100, (ActionEvent e) -> {
                if (mouseLocation != null) {
                    Point p = MouseInfo.getPointerInfo().getLocation();
                    SwingUtilities.convertPointFromScreen(p, this);
                    if (!contains(p)) {
                        setMouseLocation(null);
                    }
                }
            });
            timer.setRepeats(true);
            timer.start();
        }

        void capturePoint(MouseEvent e) {
            Component comp = e.getComponent();
            Point onThis = SwingUtilities.convertPoint(comp, e.getPoint(), this);
            boolean drawCursor = contains(onThis);

            if (drawCursor) {
                Window window = SwingUtilities.windowForComponent(this);
                if (window instanceof JFrame) {
                    Container content = ((JFrame) window).getContentPane();
                    Point onContent = SwingUtilities.convertPoint(comp, e.getPoint(), content);
                    Component deepest = SwingUtilities.getDeepestComponentAt(content, onContent.x, onContent.y);
                    if (deepest != null) {
                        if (deepest.getCursor() != BlankCursor.INSTANCE) {
                            drawCursor = false;
                        }
                    }
                }
            }

            setMouseLocation(drawCursor ? onThis : null);
        }

        void setMouseLocation(Point mouseLocation) {
            this.mouseLocation = mouseLocation;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (mouseLocation != null) {
                int x = mouseLocation.x - (cursorImage.getWidth() / 2);
                int y = mouseLocation.y - (cursorImage.getHeight() / 2);

                g.drawImage(cursorImage, x, y, this);
            }
        }
    }

    static final class BlankCursor {
        static final Cursor INSTANCE =
            Toolkit.getDefaultToolkit().createCustomCursor(
                new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB),
                new Point(),
                "BLANK");
    }

    static JPanel createTestPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        for (int i = 0; i < 9; ++i) {
            if ((i % 2) == 0) {
                JTextField field = new JTextField("Text Field");
                field.setHorizontalAlignment(JTextField.CENTER);
                panel.add(field);
            } else {
                panel.add(new JButton("Button"));
            }
        }

        return panel;
    }

    static BufferedImage createTransparentImage(BufferedImage img) {
        BufferedImage copy =
            GraphicsEnvironment.getLocalGraphicsEnvironment()
                               .getDefaultScreenDevice()
                               .getDefaultConfiguration()
                               .createCompatibleImage(img.getWidth(),
                                                      img.getHeight(),
                                                      Transparency.TRANSLUCENT);
        for (int x = 0; x < img.getWidth(); ++x) {
            for (int y = 0; y < img.getHeight(); ++y) {
                int rgb = img.getRGB(x, y) & 0x00FFFFFF;
                int bright = (((rgb >> 16) & 0xFF) + ((rgb >> 8) & 0xFF) + (rgb & 0xFF)) / 3;
                int alpha = 255 - bright;
                copy.setRGB(x, y, (alpha << 24) | rgb);
            }
        }

        return copy;
    }
}