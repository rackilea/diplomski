import SimpleUtils.noise.SimplexNoise;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Brenden Towey
 */
public class MapGenerator
{

   public static void main( String[] args )
   {
      SwingUtilities.invokeLater( new Runnable()
      {
         public void run()
         {
            JFrame frame = new JFrame();

            frame.add( new JLabel( new ImageIcon( new MapGenerator().toImage() )));

            frame.pack();
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            frame.setLocationRelativeTo( null );
            frame.setVisible( true );
         }
      } );

   }
   public double[][] toRender;

   int maxHeight = 300;
   int xResolution = 200;
   int yResolution = 200;

   public MapGenerator()
   {
      double[][] result = new double[ xResolution ][ yResolution ];
      SimplexNoise noise = new SimplexNoise();
      for( int x = 0; x < xResolution; x++ )
         for( int y = 0; y < yResolution; y++ )
            result[x][y] = transformPoint( x, y, noise.noise(x, y) );

      toRender = result;

   }

   private double transformPoint( int x, int y, double point )
   {
      point += 2 * Math.sin( x * Math.PI / xResolution )/2.0;
      point += 2 * Math.sin( y * Math.PI / yResolution )/2.0;
      return Math.min( 1.0, point);
   }

   public Image toImage()
   {
      BufferedImage image = new BufferedImage( xResolution,
              yResolution, BufferedImage.TYPE_INT_RGB );
      for( int x = 0; x < xResolution; x++ )
         for( int y = 0; y < yResolution; y++ )
            image.setRGB( x, y, greyScale( toRender[x][y] ) );
      return image;
   }

   private int greyScale( double toRender )
   {
      int scale = (int) ( 255 * toRender );
      return scale + (scale << 8) + (scale << 16);
   }
}