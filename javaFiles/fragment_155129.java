import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageEdit{
    Container content;
    BufferedImage image;
    BufferedImage  image2;
    JLabel imageLabel;

    public ImageEdit(BufferedImage image) {
        this.image = image;
    }

    public void show() {
        final int width = image.getWidth();
        final int height = image.getHeight();

        JFrame frame = new JFrame("Edit Picture");

        //set frame title, set it visible, etc
        content = frame.getContentPane();
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add the image to the frame
        ImageIcon icon = new ImageIcon(image);
        imageLabel = new JLabel(icon);
        frame.setContentPane(imageLabel);

        //add a menubar on the frame with a single option: saving the image
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem saveAction = new JMenuItem("Save");
        fileMenu.add(saveAction);
        JMenuItem grayScale = new JMenuItem("Grayscale");
        fileMenu.add(grayScale);
        grayScale.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    grayscale(width, height);
                }
            });

        //paint the frame
        frame.pack();
        frame.setVisible(true);
    }

    public void grayscale(int width, int height) {
        // create a grayscale image the same size
        image2 = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        // convert the original colored image to grayscale
        ColorConvertOp grayScale = new ColorConvertOp(
            image.getColorModel().getColorSpace(),
        image2.getColorModel().getColorSpace(),null);
        grayScale.filter(image,image2);
        imageLabel.setIcon(new ImageIcon(image2));
        //show();
    }

    public static void main(String[] args) {
        int size = 120;
        int pad = 10;
        BufferedImage bi = new BufferedImage(
            size,
            size,
            BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,size,size);
        g.setColor(Color.YELLOW);
        g.fillOval(pad,pad,size-(2*pad),size-(2*pad));
        g.dispose();

        ImageEdit p = new ImageEdit(bi);
        p.show();
    }
}