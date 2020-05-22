import java.awt.Frame;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class TestJFrame {

    private void initUI() {
        final JFrame frame = new JFrame(TestJFrame.class.getSimpleName()) {
            private Rectangle maxBounds;

            @Override
            public Rectangle getMaximizedBounds() {
                return maxBounds;
            }

            @Override
            public synchronized void setMaximizedBounds(Rectangle maxBounds) {
                this.maxBounds = maxBounds;
                super.setMaximizedBounds(maxBounds);
            }

            @Override
            public synchronized void setExtendedState(int state) {
                if (maxBounds == null && (state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {
                    Insets screenInsets = getToolkit().getScreenInsets(getGraphicsConfiguration());
                    Rectangle screenSize = getGraphicsConfiguration().getBounds();
                    Rectangle maxBounds = new Rectangle(screenInsets.left + screenSize.x, screenInsets.top + screenSize.y, screenSize.x
                            + screenSize.width - screenInsets.right - screenInsets.left, screenSize.y + screenSize.height
                            - screenInsets.bottom - screenInsets.top);
                    super.setMaximizedBounds(maxBounds);
                }

                super.setExtendedState(state);
            }
        };
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            }
        });
        JLabel label = new JLabel("some label in the middle");
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JFrame.setDefaultLookAndFeelDecorated(Boolean.TRUE);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestJFrame().initUI();
            }
        });
    }

}