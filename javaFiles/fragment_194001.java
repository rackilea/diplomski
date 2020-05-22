import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.net.URL;
import javax.swing.*;
import com.sun.awt.AWTUtilities;

@SuppressWarnings("serial")
public class MainPanelOvalFrame extends JPanel {
    private static final String RESOURCE_PATH = "imageexcel.gif";
    private Window window;
    private Image img;

    public MainPanelOvalFrame(Window window, Image image) {
        this.window = window;
        this.img = image;

        setLayout(new GridBagLayout());
        add(new JButton(new StartAction("Start", KeyEvent.VK_S)));

        int w = image.getWidth(this);
        int h = image.getHeight(this);
        Shape shape = new Ellipse2D.Float(0, 0, w, h);
        AWTUtilities.setWindowShape(window, shape);
        AWTUtilities.setWindowOpaque(window, false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet() || img == null) {
            return super.getPreferredSize();
        }
        int w = img.getWidth(this);
        int h = img.getHeight(this);
        return new Dimension(w, h);
    }

    private class StartAction extends AbstractAction {
        public StartAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            window.dispose();
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        URL imgUrl = MainPanelOvalFrame.class.getResource(RESOURCE_PATH);
        Image image = new ImageIcon(imgUrl).getImage();
        MainPanelOvalFrame mainPanel = new MainPanelOvalFrame(frame, image);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}