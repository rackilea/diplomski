import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class RenderTest {

    RenderTest() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        Dimension dim = new Dimension(50,50);
        panel.setSize(dim);
        panel.setMinimumSize(dim);
        panel.setMaximumSize(dim);
        panel.setPreferredSize(dim);
        JLabel label = new JLabel("hello");
        label.setSize(label.getPreferredSize());
        panel.add(label);

        BufferedImage bi = getScreenShot(panel);
        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(bi)));
    }

    private BufferedImage getScreenShot(JPanel panel){
        BufferedImage bi = new BufferedImage(
            panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_ARGB);
        panel.paint(bi.getGraphics());
        return bi;
    }

    public static void main(String[] args) {
        new RenderTest();
    }
}