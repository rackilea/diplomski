import java.awt.geom.AffineTransform;

public class TransRotScal {

   public static void main( String[] args ) {
      double theta = Math.atan2( -15.0, 40.0 );
      AffineTransform trans = new AffineTransform(); // Identity
      trans.scale( 1/43.0, 1.0 );
      trans.rotate( theta );
      trans.translate( -10, -20 );
      double[] in = {
         10, 20,
         10, 30,
         50, 30,
         50, 35
      };
      double[] out = new double[in.length];
      trans.transform( in, 0, out, 0, in.length/2 );
      for( int ptNdx = 0; ptNdx < out.length; ptNdx += 2 ) {
         System.out.printf( "{%7.4f, %7.4f }\n", out[ptNdx], out[ptNdx+1]);
      }
   }
}