import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FullScreenTest {

    public static void main(String[] args) {
        new FullScreenTest();
    }

    public FullScreenTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new TestPane());

                DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
                Screen.setFullScreen(null, frame);

                Timer timer = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Screen.restoreScreen();
                    }
                });
                timer.start();
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setFont(new Font("Arial", Font.PLAIN, 24));
            setBackground(Color.RED);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g.drawString("This is awesome", 200, 200);
            g2d.dispose();
        }

    }

    public static class Screen {

        public static GraphicsDevice getGraphicsDevice() {
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            return env.getDefaultScreenDevice();
        }

        public static void setFullScreen(DisplayMode dm, JFrame window) {
            window.setUndecorated(true);
            window.setResizable(false);
            GraphicsDevice gd = getGraphicsDevice();
            gd.setFullScreenWindow(window);
            if (dm != null && gd.isDisplayChangeSupported()) {
                try {
                    gd.setDisplayMode(dm);
                } catch (Exception ex) {
                }
            }
        }

        public static Window getFullScreenWindow() {
            GraphicsDevice gd = getGraphicsDevice();
            return gd.getFullScreenWindow();
        }

        public static void restoreScreen() {
            GraphicsDevice gd = getGraphicsDevice();
            Window w = gd.getFullScreenWindow();
            if (w != null) {
                w.dispose();
            }
            gd.setFullScreenWindow(null);
        }
    }

}