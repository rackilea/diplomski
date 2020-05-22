import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BackgroundExample {

    private JTextField tField;
    private JButton button;

    private CustomPanel contentPane;

    private void displayGUI() {
        JFrame frame = new JFrame("Background Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new CustomPanel();
        contentPane.setLayout(new GridBagLayout());

        JPanel componentPanel = new JPanel();
        componentPanel.setOpaque(false);
        tField = new JTextField("Nothing to display yet...", 20);
        button = new JButton("Click me not!");
        componentPanel.add(tField);
        componentPanel.add(button);

        contentPane.add(componentPanel);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new BackgroundExample().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}

class CustomPanel extends JPanel {

    private BufferedImage bImage;

    public CustomPanel() {
        try {
            bImage = ImageIO.read(new URL("http://i.imgur.com/fHiBMwI.jpg"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return (bImage != null ? new Dimension(
            bImage.getWidth(), bImage.getHeight()) : new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bImage, 0, 0, this);
    }
}