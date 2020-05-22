import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.sf.image4j.codec.ico.ICODecoder;

public class ReadFavicon {

    public static void main(String[] args) {
        new ReadFavicon();
    }

    public ReadFavicon() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
                    BufferedImage img = readIcon(new URL("https://secure.gravatar.com/favicon.ico"));
                    JOptionPane.showMessageDialog(null, "My FAVICON", "Icon", JOptionPane.PLAIN_MESSAGE, new ImageIcon(img));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public BufferedImage readIcon(URL url) throws IOException {
        BufferedImage img = null;
        InputStream is = null;
        try {
            // url begin an instance of java.net.URL
            is = url.openStream();
            List<BufferedImage> imgs = ICODecoder.read(is);
            img = imgs != null ? imgs.size() > 0 ? imgs.get(0) : null : null;
        } finally {
            try {
                is.close();
            } catch (Exception exp) {
            }
        }
        return img;
    }

}