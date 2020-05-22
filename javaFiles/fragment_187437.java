import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImageIconArray {

    private JButton[][] buttons = new JButton[16][16];
    private JPanel pane;
    private JFrame frame;
    private GridBagConstraints constraints = new GridBagConstraints();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageIconArray().createAndShowGui();
            }
        });
    }

    public void createAndShowGui() {
        BufferedImage img = null;
        URL url;
        try {
            url = new URL("https://i.stack.imgur.com/L5DGx.png");
            img = ImageIO.read(url);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Icon cell = new ImageIcon(img);
        frame = new JFrame("Example");
        pane = new JPanel();
        pane.setLayout(new GridLayout(16, 16));

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setIcon(cell);
                constraints.gridx = i;
                constraints.gridy = j;
                constraints.weightx = 1;
                pane.add(buttons[i][j], constraints);

            }
        }
        frame.add(pane);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}