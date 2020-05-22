import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FullWindow extends JFrame {
    private boolean isFullScreen = false;
    private GraphicsDevice device;

    public FullWindow(GraphicsDevice device) {
        this.device = device;
        initFullScreen();
    }

    private void initFullScreen() {
        isFullScreen = device.isFullScreenSupported();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(isFullScreen);
        setResizable(!isFullScreen);
        if (isFullScreen) {
            // Full-screen mode
            device.setFullScreenWindow(this);
            validate();
        } else {
            // Windowed mode
            this.setExtendedState(MAXIMIZED_BOTH);
            this.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GraphicsEnvironment env = GraphicsEnvironment
                        .getLocalGraphicsEnvironment();
                GraphicsDevice device = env.getDefaultScreenDevice();
                new FullWindow(device);
            }
        });
    }
}