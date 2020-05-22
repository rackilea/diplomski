import javax.swing.*;
import java.awt.*;

public class Hexagons
{
    public static void main ( String...args ) throws Exception
    {
        SwingUtilities.invokeAndWait ( new Runnable () {
            @Override
            public void run () {
                new Hexagons().run();
            }
        } );
    }

    Hexagons ()
    {
        final JFrame frame = new JFrame();

        frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );

        final JPanel panel = new JPanel () {
            @Override
            public void paintComponent ( Graphics g ) {
                Graphics2D g2D = ( Graphics2D ) g;

                g2D.setRenderingHint ( RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON );

                drawHexes ( g2D, getWidth() / 2, getHeight() / 2 );
            }
        };

        count = 5;

        frame.add ( panel );
        frame.setSize ( 400, 400 );
        frame.setVisible ( true );

    }

    void run () { }

    int count;


    void drawHexes ( Graphics2D g, int cx, int cy )
    {
        int count = Math.min ( 20, Math.min ( cx, cy ) / 34 );

        drawHex ( g, cx, cy, 0 );

        for ( int rank = 1; rank < count; ++rank ) {

            for ( int bar = 0; bar < 6; ++bar ) {
                int x = ( polyX [ ( bar + 4 ) % 6 ] + polyX [ ( bar + 5 ) % 6 ] ) * rank;
                int y = ( polyY [ ( bar + 4 ) % 6 ] + polyY [ ( bar + 5 ) % 6 ] ) * rank;

                int dx = polyX [ bar ] + polyX [ ( bar + 1 ) % 6 ];
                int dy = polyY [ bar ] + polyY [ ( bar + 1 ) % 6 ];

                for ( int hex = 0; hex < rank; ++hex ) {
                    drawHex ( g, cx + x, cy + y, rank );
                    x += dx;
                    y += dy;
                }
            }
        }
    }

    static int polyX[] = { 20, 10, -10, -20, -10,  10 };
    static int polyY[] = {  0, 17,  17,   0, -17, -17 }; 
    static Color fill[] = new Color[20];
    static Color line[] = new Color[20];
    static BasicStroke stroke = new BasicStroke ( 1.5f );

    // make it pretty
    static {
        for ( int rank = 0; rank < 20; ++rank ) {
            double theta0 = rank * 2 * Math.PI / 20;
            double theta1 = theta0 + Math.PI * 2.0/3.0;
            double theta2 = theta1 + Math.PI * 2.0/3.0;

            fill [ rank ] = new Color ( 
                ( int ) ( 128 + 64 * Math.sin ( theta0 ) ),
                ( int ) ( 128 + 64 * Math.sin ( theta1 ) ),
                ( int ) ( 128 + 64 * Math.sin ( theta2 ) ) );
            line [ rank ] = new Color ( 
                ( int ) ( 64+ 32 * Math.sin ( theta0 ) ),
                ( int ) ( 64 + 32 * Math.sin ( theta1 ) ),
                ( int ) ( 64+ 32 * Math.sin ( theta2 ) ) );
        }
    }

    void drawHex ( Graphics2D g, int cx, int cy, int rank ) {
        g.translate ( cx, cy );
        g.setPaint ( fill [ rank ] );
        g.fillPolygon ( polyX, polyY, 6 );
        g.setColor ( line [ rank ] );
        g.setStroke ( stroke );
        g.drawPolygon ( polyX, polyY, 6 );
        g.translate ( -cx, -cy );
    }
}