import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.spi.IIORegistry;
import javax.imageio.spi.ImageWriterSpi;
import javax.imageio.spi.ServiceRegistry;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Test {

    public static void main(String[] args) {
        try {
            BufferedImage original = ImageIO.read(...);
            BufferedImage bufferedJpgImage = new BufferedImage(original.getWidth(null),
                            original.getHeight(null),
                            BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufferedJpgImage.createGraphics();
            g.drawImage(original, 0, 0, original.getWidth(), original.getHeight(), Color.WHITE, null);
            g.dispose();

            File jpg = new File("tmp.jpg");

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

                write(bufferedJpgImage, baos);

                try (ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray())) {

                    BufferedImage image = ImageIO.read(bais);

                    JPanel panel = new JPanel();
                    panel.add(new JLabel(new ImageIcon(original)));
                    panel.add(new JLabel(new ImageIcon(image)));

                    JOptionPane.showMessageDialog(null, panel);

                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void write(BufferedImage capture, OutputStream to) throws IOException {
// use IIORegistry to get the available services
        IIORegistry registry = IIORegistry.getDefaultInstance();
// return an iterator for the available ImageWriterSpi for jpeg images
        Iterator<ImageWriterSpi> services = registry.getServiceProviders(ImageWriterSpi.class,
                        new ServiceRegistry.Filter() {
                            @Override
                            public boolean filter(Object provider) {
                                if (!(provider instanceof ImageWriterSpi)) {
                                    return false;
                                }

                                ImageWriterSpi writerSPI = (ImageWriterSpi) provider;
                                String[] formatNames = writerSPI.getFormatNames();
                                for (int i = 0; i < formatNames.length; i++) {
                                    if (formatNames[i].equalsIgnoreCase("JPEG")) {
                                        return true;
                                    }
                                }

                                return false;
                            }
                        },
                        true);
//...assuming that servies.hasNext() == true, I get the first available service.
        ImageWriterSpi writerSpi = services.next();
        ImageWriter writer = writerSpi.createWriterInstance();

// specifies where the jpg image has to be written      
        writer.setOutput(ImageIO.createImageOutputStream(to));

        JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(null);
        jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        jpegParams.setCompressionQuality(1f);

// writes the file with given compression level 
// from your JPEGImageWriteParam instance
        writer.write(null, new IIOImage(capture, null, null), jpegParams);
    }

}