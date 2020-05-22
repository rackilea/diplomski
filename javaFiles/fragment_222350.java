import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) throws IOException {
        final Image image = ImageIO.read(new File("logo.png"));
        final JFrame frame = new JFrame();
        JPanel imagePanel = new ImagePanel(image);
         imagePanel.setLayout(new BorderLayout()); // setting layout as BorderLayout
        JPanel anotherPanel = new JPanel();  /// multiple panel, 
        anotherPanel.setSize(100, 290);
        anotherPanel.setOpaque(false); // THIS IS VERY MUCH IMPORTANT
        anotherPanel.add(new JButton("Alpesh Gediya"));
        imagePanel.add(anotherPanel); //add panel to ImagePanel
        frame.add(imagePanel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

@SuppressWarnings("serial")
class ImagePanel extends JPanel {
    private Image image;
    private boolean tile;

    ImagePanel(Image image) {
        this.image = image;
        this.tile = false;
        final JCheckBox checkBox = new JCheckBox();
        checkBox.setAction(new AbstractAction("Tile") {
            public void actionPerformed(ActionEvent e) {
                tile = checkBox.isSelected();
                repaint();
            }
        });
        add(checkBox, BorderLayout.SOUTH);
    };

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (tile) {
            int iw = image.getWidth(this);
            int ih = image.getHeight(this);
            if (iw > 0 && ih > 0) {
                for (int x = 0; x < getWidth(); x += iw) {
                    for (int y = 0; y < getHeight(); y += ih) {
                        g.drawImage(image, x, y, iw, ih, this);
                    }
                }
            }
        } else {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}