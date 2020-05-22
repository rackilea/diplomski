import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author Pasban
 */
public class VainillaImage {

    private ImageIcon icimg;
    private JLabel imagen;

    public static void main(String args[]) {
        JDialog d = new JDialog();
        VainillaImage v = new VainillaImage("92-1024x576.jpg");
        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        d.getContentPane().add(v.imagen);
        v.setDimensions(-1, 1);
        d.pack();
        d.setLocationRelativeTo(null);
        d.setVisible(true);
    }

    public void setDimensions(double width, double height) {
        Dimension dimPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int nwidth, nheight;
        nwidth = (int) (width * (dimPantalla.width));
        nheight = (int) (height * (dimPantalla.height));
        resizeVainillaImg(nwidth, nheight);
    }

    public void resizeVainillaImg(int newWidth, int newHeight) {
        Image img = this.icimg.getImage();
        newWidth = Math.max(newWidth, img.getHeight(null));
        newWidth = Math.max(newHeight, img.getHeight(null));
        BufferedImage bi = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newWidth, newHeight, null);
        g.dispose();
        this.icimg = new ImageIcon(bi);
        this.imagen.setIcon(this.icimg);
    }

    public VainillaImage(String url) {
        this.icimg = new ImageIcon(url);
        this.imagen = new JLabel(this.icimg);
        this.imagen.setVisible(true);
    }
}