import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TestMultipleScreens {

    private int count = 1;

    protected void initUI() {
        Point p = null;
        for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
            p = gd.getDefaultConfiguration().getBounds().getLocation();
            break;
        }
        createFrameAtLocation(p);
    }

    private void createFrameAtLocation(Point p) {
        final JFrame frame = new JFrame();
        frame.setTitle("Frame-" + count++);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        final JButton button = new JButton("Click me to open new frame on another screen (if you have two screens!)");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GraphicsDevice device = button.getGraphicsConfiguration().getDevice();
                Point p = null;
                for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
                    if (!device.equals(gd)) {
                        p = gd.getDefaultConfiguration().getBounds().getLocation();
                        break;
                    }
                }
                createFrameAtLocation(p);
            }
        });
        frame.add(button);
        frame.setLocation(p);
        frame.pack(); // Sets the size of the unmaximized window
        frame.setExtendedState(Frame.MAXIMIZED_BOTH); // switch to maximized window
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestMultipleScreens().initUI();
            }
        });
    }

}