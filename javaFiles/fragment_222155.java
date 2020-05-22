import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

// extend JPanel so you can draw to its background
@SuppressWarnings("serial")
public class Menu2 extends JPanel {
    private BufferedImage bgImage = null; // our background image
    private JButton playButton = new JButton(new PlayVsAiAction("Play Vs. AI", KeyEvent.VK_P));

    public Menu2(BufferedImage bgImage) {
        this.bgImage = bgImage;

        setLayout(new GridBagLayout());  // center our button
        add(playButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bgImage != null) {
            g.drawImage(bgImage, 0, 0, this);
        }
    }

    // to size our GUI to match a constant or the image.
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }

        // if you want to size it based on the image
        if (bgImage != null) {
            int width = bgImage.getWidth();
            int height = bgImage.getHeight();
            return new Dimension(width, height);            
        } else {
            return super.getPreferredSize();
        }

        // if you want to size the GUI with constants:
        // return new Dimension(PREF_W, PREF_H);
    }

    private class PlayVsAiAction extends AbstractAction {
        public PlayVsAiAction(String name, int mnemonic) {
            super(name); // have our button display this name
            putValue(MNEMONIC_KEY, mnemonic); // alt-key to press button
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO code to start program

        }
    }

    private static void createAndShowGui() {
        BufferedImage img = null;
        String imagePath = "res/img/background.png";
        try {
            // TODO: fix this -- use class resources to get image, not File 
            img = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        Menu2 mainPanel = new Menu2(img);

        JFrame frame = new JFrame("Chinese Chess");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}