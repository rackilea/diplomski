import java.awt.BorderLayout;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    public static void main(String[] args) {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = graphicsEnvironment.getScreenDevices();
        new MainFrame(devices[0]);
    }

    private GraphicsDevice graphicsDevice;
    private DisplayMode origDisplay;
//    private final JRootPane rootPane;

    public MainFrame(GraphicsDevice graphicsDevice) {
        super();
        this.setGraphicsDevice(graphicsDevice);
        this.setOrigDisplay(graphicsDevice.getDisplayMode());

//        rootPane = new JRootPane();
        setContentPane(TitleScreenPanel.getInstance(this));
//        add(rootPane, BorderLayout.CENTER);

        if (graphicsDevice.isFullScreenSupported()) {
            setUndecorated(true);
            setResizable(false);
            graphicsDevice.setFullScreenWindow(this);
            revalidate();
        } else {
            System.out.println("Full-screen mode not supported");
        }

//        try {
//            Theme.loadTheme(new File("res/IS.theme"));
//            UIManager.setLookAndFeel(new TinyLookAndFeel());
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
//        SwingUtilities.updateComponentTreeUI(this);
//        Toolkit.getDefaultToolkit().setDynamicLayout(true);
        System.setProperty("sun.awt.noerasebackground", "true");
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        JDialog.setDefaultLookAndFeelDecorated(true);
//        rootPane.revalidate();

    }

    public DisplayMode getOrigDisplay() {
        return origDisplay;
    }

    public void setOrigDisplay(DisplayMode origDisplay) {
        this.origDisplay = origDisplay;
    }

    public GraphicsDevice getGraphicsDevice() {
        return graphicsDevice;
    }

    public void setGraphicsDevice(GraphicsDevice graphicsDevice) {
        this.graphicsDevice = graphicsDevice;
    }

    public static class TitleScreenPanel extends JPanel {

        private static TitleScreenPanel titleScreenPanel;
        private JButton exitButton;
        private JButton startButton;

        private TitleScreenPanel(final MainFrame context) {
            setLayout(new BorderLayout());
            startButton = new JButton("START");
            startButton.setFont(startButton.getFont().deriveFont(48f));
            startButton.setBorder(BorderFactory.createEmptyBorder());
            startButton.setContentAreaFilled(false);
            exitButton = new JButton("Exit Full-Screen Mode");
            exitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    context.getGraphicsDevice().setDisplayMode(context.getOrigDisplay());
                    System.exit(0);
                }
            });
            this.add(startButton, BorderLayout.CENTER);
            this.add(exitButton, BorderLayout.SOUTH);
        }

        public static TitleScreenPanel getInstance(MainFrame context) {
            if (titleScreenPanel == null) {
                titleScreenPanel = new TitleScreenPanel(context);
            }
            return titleScreenPanel;
        }
    }
}