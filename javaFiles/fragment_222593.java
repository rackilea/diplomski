import java.awt.*;
import java.awt.datatransfer.*;

public class ClipboardImage
{
    /**
     *  Retrieve an image from the system clipboard.
     *
     *  @return the image from the clipboard or null if no image is found
     */
    public static Image read()
    {
        Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents( null );

        try
        {
            if (t != null && t.isDataFlavorSupported(DataFlavor.imageFlavor))
            {
                Image image = (Image)t.getTransferData(DataFlavor.imageFlavor);
                return image;
            }
        }
        catch (Exception e) {}

        return null;
    }

    /**
     *  Place an image on the system clipboard.
     *
     *  @param  image - the image to be added to the system clipboard
     */
    public static void write(Image image)
    {
        if (image == null)
            throw new IllegalArgumentException ("Image can't be null");

        ImageTransferable transferable = new ImageTransferable( image );
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(transferable, null);
    }

    static class ImageTransferable implements Transferable
    {
        private Image image;

        public ImageTransferable (Image image)
        {
            this.image = image;
        }

        public Object getTransferData(DataFlavor flavor)
            throws UnsupportedFlavorException
        {
            if (isDataFlavorSupported(flavor))
            {
                return image;
            }
            else
            {
                throw new UnsupportedFlavorException(flavor);
            }
        }

        public boolean isDataFlavorSupported (DataFlavor flavor)
        {
            return flavor == DataFlavor.imageFlavor;
        }

        public DataFlavor[] getTransferDataFlavors ()
        {
            return new DataFlavor[] { DataFlavor.imageFlavor };
        }
    }

    public static void main(String[] args)
    {
        Image image = Toolkit.getDefaultToolkit ().createImage("???.jpg");
        ClipboardImage.write( image );

        javax.swing.ImageIcon icon = new javax.swing.ImageIcon( ClipboardImage.read() );
        javax.swing.JLabel label = new javax.swing.JLabel( icon );

        javax.swing.JFrame frame = new javax.swing.JFrame();
        frame.setDefaultCloseOperation( javax.swing.JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().add( label );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}