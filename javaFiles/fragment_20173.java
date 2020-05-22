import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

public class ImageToBinary
{
    public static void main(String[] args) throws Exception
    {
        BufferedImage input = 
            ImageIO.read(new URL("https://i.stack.imgur.com/jvOan.png"));        

        BufferedImage output = convertToBinary(input, 10);

        SwingUtilities.invokeLater(() -> createAndShowGui(input, output));
    }

    private static void createAndShowGui(
        BufferedImage input, BufferedImage output)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new GridLayout(1,2));
        JLabel outputLabel = new JLabel(new ImageIcon(output));
        p.add(new JLabel(new ImageIcon(input)));    
        p.add(outputLabel);
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(p, BorderLayout.NORTH);   

        JSlider slider = new JSlider(0, 256, 10);
        slider.addChangeListener(e -> 
        {
            int threshold = slider.getValue();
            BufferedImage newOutput = convertToBinary(input, threshold);
            outputLabel.setIcon(new ImageIcon(newOutput));
        });

        f.getContentPane().add(slider, BorderLayout.SOUTH);
        f.pack();

        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }

    private static BufferedImage convertToBinary(
        BufferedImage input, int threshold)
    {
        int w = input.getWidth();
        int h = input.getHeight();
        BufferedImage output = new BufferedImage(
            w, h, BufferedImage.TYPE_BYTE_BINARY);

        int blackRgb = Color.BLACK.getRGB();
        int whiteRgb = Color.WHITE.getRGB();

        for (int y = 0; y < h; y++)
        {
            for (int x = 0; x < w; x++)
            {

                int rgb = input.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb) & 0xFF;
                int gray = (int) (0.2126 * r + 0.7152 * g + 0.0722 * b);
                if (gray >= threshold)
                {
                    output.setRGB(x, y, whiteRgb);
                }
                else
                {
                    output.setRGB(x, y, blackRgb);
                }
            }
        }
        return output;
    }        

}