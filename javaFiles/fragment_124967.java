import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChangeImageBrightnessExample2 {

    public static void main( String[] args ) throws IOException {
        new ChangeImageBrightnessExample2().createUI();
    }

    public void createUI() throws IOException {

        Image img = ImageIO.read( new File( "image.jpeg" ) );

        new JFrame(){
            {
                setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                setSize( 800, 600 );
                setLocationRelativeTo( null );

                CustomPanel panel = new CustomPanel();
                panel.setImage( img );

                JSlider slider = new JSlider( 0, 400, 100 );
                slider.setMinorTickSpacing( 10);
                slider.setMajorTickSpacing( 50 );
                slider.setPaintLabels( true );
                slider.setPaintTicks( true );
                slider.setSnapToTicks( true );
                slider.addChangeListener( new ChangeListener() {
                    @Override
                    public void stateChanged( ChangeEvent evt ) {
                        JSlider s = ((JSlider) evt.getSource());
                        if ( s.getValueIsAdjusting() ) {
                            panel.setMaximumBrightnessPercentage( s.getValue()/100f );
                            panel.repaint();
                        }

                    }
                });

                add( panel, BorderLayout.CENTER );
                add( slider, BorderLayout.SOUTH );

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

                // calculates the brightness component.
                float newBrightness = hsbvals[2] * brightnessPercentage;
                if ( newBrightness > 1f ) {
                    newBrightness = 1f;
                }

                // create a new color with the new brightness
                Color c = new Color( Color.HSBtoRGB( hsbvals[0], hsbvals[1], newBrightness ) );

                // set the new pixel
                bi.getRaster().setPixel( j, i, new int[]{ c.getRed(), c.getGreen(), c.getBlue(), pixel[3] } );

            }

        }

        return bi;

    }

    private class CustomPanel extends JPanel {

        private float maximumBrightnessPercentage = 1f;
        private Image image;

        @Override
        protected void paintComponent( Graphics g ) {

            super.paintComponent( g );

            int imgWidth = image.getWidth( null );
            int imgHeight = image.getHeight( null );
            int lines = 4;
            int columns = 6;
            int count = 1;

            for ( int i = 0; i < lines; i++ ) {
                for ( int j = 0; j < columns; j++ ) {
                    float newBrightness = maximumBrightnessPercentage/(lines*columns)*count;
                    g.drawImage( newBrightness( image, newBrightness ), imgWidth * j, imgHeight * i, null );
                    g.drawString( String.format( "%.2f%%", newBrightness*100 ), imgWidth * j, imgHeight * i + 10 );
                    count++;
                }
            }

        }

        public void setMaximumBrightnessPercentage( float maximumBrightnessPercentage ) {
            this.maximumBrightnessPercentage = maximumBrightnessPercentage;
        }

        public void setImage( Image image ) {
            this.image = image;
        }

    }

}