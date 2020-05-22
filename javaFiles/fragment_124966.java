import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

    public static void main( String[] args ) throws IOException {

        Image img = ImageIO.read( new File( "image.jpeg" ) );

        new JFrame(){
            {
                setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                setSize( 800, 600 );
                setLocationRelativeTo( null );
                add( new JPanel(){
                    @Override
                    protected void paintComponent( Graphics g ) {

                        super.paintComponent( g );

                        int imgWidth = img.getWidth( null );
                        int imgHeight = img.getHeight( null );
                        int lines = 4;
                        int columns = 6;
                        int count = 1;

                        for ( int i = 0; i < lines; i++ ) {
                            for ( int j = 0; j < columns; j++ ) {
                                g.drawImage( newBrightness( img, 1f/(lines*columns)*count ), imgWidth * j, imgHeight * i, null );
                                count++;
                            }
                        }
                    }
                });
            }
        }.setVisible( true );

    }

    public static Image newBrightness( Image source, float brightnessPercentage ) {

        BufferedImage bi = new BufferedImage( 
                source.getWidth( null ), 
                source.getHeight( null ), 
                BufferedImage.TYPE_INT_ARGB );

        int[] pixel = { 0, 0, 0, 0 };
        float[] hsbvals = { 0, 0, 0 };

        bi.getGraphics().drawImage( source, 0, 0, null );

        // recalculare every pixel, changing the brightness
        for ( int i = 0; i < bi.getHeight(); i++ ) {
            for ( int j = 0; j < bi.getWidth(); j++ ) {

                // get the pixel data
                bi.getRaster().getPixel( j, i, pixel );

                // converts its data to hsb to change brightness
                Color.RGBtoHSB( pixel[0], pixel[1], pixel[2], hsbvals );

                // create a new color with the changed brightness
                Color c = new Color( Color.HSBtoRGB( hsbvals[0], hsbvals[1], hsbvals[2] * brightnessPercentage ) );

                // set the new pixel
                bi.getRaster().setPixel( j, i, new int[]{ c.getRed(), c.getGreen(), c.getBlue(), pixel[3] } );

            }

        }

        return bi;

    }

}