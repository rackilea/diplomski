import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
public class TransparentTest
{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    BufferedImage image = ImageIO.read(new File("KING.jpg"));
                    BufferedImage transparentImage = removeColors(image,new Color(245,222,180));
                    createAndShowGUI(image,transparentImage);
                }
                catch(IOException ex) {
                    JOptionPane.showMessageDialog(null,"Please check your file image path","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public static void createAndShowGUI(BufferedImage image,BufferedImage transparentImage) {
        JPanel pane = new JPanel(new FlowLayout(FlowLayout.CENTER,40,10));
        pane.setBackground(Color.BLUE);
        pane.add(new JLabel(new ImageIcon(image)));
        pane.add(new JLabel(new ImageIcon(transparentImage)));
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(pane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static BufferedImage removeColors(BufferedImage image,Color... colorsBlackList) throws IOException {
        int height = image.getHeight(), width=image.getWidth();
        BufferedImage transparentImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB); 
        for(int y=0;y<height;y++) {
            for(int x=0;x<width;x++) {
                int pixel = image.getRGB(x,y);
                int red = (pixel>>16) &0xff;
                int green = (pixel>>8) &0xff;
                int blue = (pixel>>0) &0xff;
                int alpha = 255;
                // Settings opacity to 0 ("transparent color") if the pixel color is equal to a color taken from the "blacklist"
                for(Color color : colorsBlackList) {
                    if(color.getRGB() == pixel) alpha = 0;
                }
                transparentImage.setRGB(x,y,(alpha&0x0ff)<<24 | red<<16 | green<<8 | blue);
            }
        }
        return transparentImage;
    }
}