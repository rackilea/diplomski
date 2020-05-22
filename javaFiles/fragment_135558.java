import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.NavigableMap;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageParser {
    public static void main(String[] args) {
        String dataContent = 
            "6 5\n" + 
            ".7 .7 .6 1.0 1.2 .1\n" + 
            ".9 .3 .7 1.1 .7 .2\n" + 
            "1 1.1 1.2 1.3 1.7 .6\n" + 
            ".5 .6 .5 .4 .9 .1101\n" + 
            "2 .1 .1 .1 2.1 1.1";

        String colorContent = 
            "0 .5 255 128 64\n" + 
            ".5 .75 128 255 32\n" + 
            ".75 1.25 64 64 225\n" + 
            "01.50 5 128 128 0";

        int width = 0;
        int height = 0;
        BufferedImage image = null;

        NavigableMap<Double, Integer> colorMap = new TreeMap<Double, Integer>();
        for (String colorLine : colorContent.split( "\n" )) {
            String[] colorValues = colorLine.split( " " );
            colorMap.put( Double.parseDouble( colorValues[1] ), 
                    Integer.parseInt( colorValues[2] ) << 16 | 
                    Integer.parseInt( colorValues[3] ) << 8 | 
                    Integer.parseInt( colorValues[4] ) );
        }
        boolean headerParsed = false;
        int y = 0;
        for( String dataLine : dataContent.split( "\n" ) ) {
            String[] dataArray = dataLine.split( " " );
            if( !headerParsed ) {
                width = Integer.parseInt( dataArray[ 0 ] );
                height = Integer.parseInt( dataArray[ 1 ] );
                image = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB );
                headerParsed = true;
            }
            else {
                int x = 0;
                for( String data : dataArray ) {
                    Integer rgbValue = colorMap.higherEntry( Double.parseDouble( data ) ).getValue();
                    image.setRGB( x, y, rgbValue );
                    x++;
                }
                y++;
            }
        }

        JFrame frame = new JFrame();
        frame.getContentPane().add( new Viewer( image, width, height, 20 ) );
        frame.pack();
        frame.setVisible( true );
    }

    static class Viewer extends JPanel {
        Image m_image;
        int m_width;
        int m_height;
        int m_zoom;
        public Viewer( Image image, int width, int height, int zoom ) {
            m_image = image;
            m_width = width;
            m_height = height;
            m_zoom = zoom;
        }

        @Override
        public void paint(Graphics g) {
            g.drawImage( m_image, 0, 0, m_width * m_zoom, m_height * m_zoom, this );
        }
    };
}