import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.opencv.core.*;     
import org.opencv.videoio.VideoCapture;

public class ApplicationBase {

    private BufferedImage m_Captured_BufferedImage;

    static {
        System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary ( Core.NATIVE_LIBRARY_NAME );
    }

    private void displayGUI ( BufferedImage image, String title, int x, int y ) {
        JFrame frame = new JFrame ( title );
        frame.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );

        JPanel contentPane = new JPanel ( new BorderLayout ( 5, 5 ) );

        PictureDrawer pictureDrawer = new PictureDrawer ( image );
        contentPane.add ( pictureDrawer, BorderLayout.CENTER );

        JButton button = new JButton ( "Click Me not!" );
        contentPane.add ( button, BorderLayout.PAGE_END );

        frame.setContentPane ( contentPane );
        frame.pack ();
        frame.setLocationByPlatform ( true );
        frame.setVisible ( true );
    }

    private void startApp () {
        VideoCapture camera = new VideoCapture ( 0 );

        Mat videoFrame = new Mat ();
        camera.read ( videoFrame );

        if ( camera.read ( videoFrame ) ) {
            m_Captured_BufferedImage = matToBufferedImage ( videoFrame );
            Runnable runnable = new Runnable () {
                @Override
                public void run () {
                    displayGUI ( m_Captured_BufferedImage, "Image", 0, 0 );
                }
            };                  
            EventQueue.invokeLater ( runnable );
        }
        camera.release ();
    }

    public BufferedImage matToBufferedImage ( Mat videoFrame ) {
        //Mat() to BufferedImage
        int type = 0;
        if ( videoFrame.channels () == 1 ) {
            type = BufferedImage.TYPE_BYTE_GRAY;
        } else if ( videoFrame.channels () == 3 ) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        BufferedImage image = new BufferedImage ( videoFrame.width (), videoFrame.height (), type );
        WritableRaster raster = image.getRaster ();
        DataBufferByte dataBuffer = ( DataBufferByte ) raster.getDataBuffer ();
        byte [] data = dataBuffer.getData ();
        videoFrame.get ( 0, 0, data );

        return image;
    }

    public static void main ( String [] args ) {
        new ApplicationBase ().startApp ();
    }
}

class PictureDrawer extends JComponent {

    private BufferedImage m_BufferedImage;

    public PictureDrawer ( BufferedImage bufferedImage ) {
        this.m_BufferedImage = bufferedImage;
    }

    @Override
    protected void paintComponent ( Graphics g ) {
        super.paintComponent ( g );
        g.drawImage ( m_BufferedImage, 0, 0, this );
    }

    @Override
    public Dimension getPreferredSize () {
        return new Dimension ( m_BufferedImage.getWidth (), m_BufferedImage.getHeight () );
    }
}