import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Layout
{
    public static void main( String[] args )
    {
        JFrame f = new JFrame( "Sample" );
        Grid x = new Grid( 50, 50 );
        f.add( x );
        f.pack( );
        f.setVisible( true );
        f.setSize( 600, 600 );
        f.setResizable( false );
        f.setLocationRelativeTo( null );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    static class Cell
    {

    }

    public static class Grid extends Canvas
    {

        Cell[][] maze;
        int rows;
        int cols;

        Grid( int rows, int cols )
        {
            this.rows = rows;
            this.cols = cols;
            maze = new Cell[rows][cols];
        }

        public void paint( Graphics g )
        {
            int k;

            double width = getSize( ).width;
            double height = getSize( ).height;

            double htOfRow = height / ( rows );
            for ( k = 0; k < rows; k++ )
                g.drawLine( 0, ( int ) ( k * htOfRow ), ( int ) width, ( int ) ( k * htOfRow ) );

            double wdOfRow = width / ( cols );
            for ( k = 0; k < cols; k++ )
                g.drawLine( ( int ) ( k * wdOfRow ), 0, ( int ) ( k * wdOfRow ), ( int ) height );
        }
    }
}