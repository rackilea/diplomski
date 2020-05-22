import java.awt.image.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.net.URL;

public class ImageEditEngine {

    private static int[][][] originalImage;
    private static BufferedImage originalImageBuffer;

    public ImageEditEngine() {
        originalImage = new int[0][0][0];
        ImageGUI gui = new ImageGUI();
        gui.setVisible(true);
    }

    public static ImageIcon openImage(){
        try{
            URL url = new URL("https://i.stack.imgur.com/OVOg3.jpg");

            BufferedImage image = ImageIO.read(url);
            originalImageBuffer = image;
            ImageIcon icon = new ImageIcon(image);
            return icon;

        }
        catch(Exception e){
            e.printStackTrace();
            return new ImageIcon();
        }
    }

    public static void main(String[] args) {
        new ImageEditEngine();
    }
}


class ImageGUI extends JFrame {

    private JPanel mainPanel;

    public ImageIcon img;

    private JLabel mLabel;

    public ImageGUI(){
        super();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //main panel
        mainPanel = new JPanel(new BorderLayout());
        mLabel = new JLabel();
        mainPanel.add(mLabel, BorderLayout.CENTER);

        add(mainPanel);

        setSize(new Dimension(400, 300));

        img=ImageEditEngine.openImage();
        mLabel.setIcon(img);
        mLabel.setVisible(true);
        this.repaint();
        pack();
    }
}