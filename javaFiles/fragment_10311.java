import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MouseTracker4July extends JFrame implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
    private final JLabel mousePosition;
    int x1, x2, y1, y2;
    int x, y, w, h;
    private final JLabel recStart;
    private final JLabel recStop;
    private final JLabel cords; // set up GUI and register mouse event handlers
    boolean isNewRect = true;

    public MouseTracker4July() {
        super( "Rectangle Drawer" );

        this.mousePosition = new JLabel();
        this.mousePosition.setHorizontalAlignment( SwingConstants.CENTER );
        getContentPane().add( this.mousePosition, BorderLayout.CENTER );

        JLabel text1 = new JLabel();
        text1.setText( "At the center the mouse pointer's coordinates will be displayed." );
        getContentPane().add( text1, BorderLayout.SOUTH );

        this.recStart = new JLabel();
        getContentPane().add( this.recStart, BorderLayout.WEST );

        this.recStop = new JLabel();
        getContentPane().add( this.recStop, BorderLayout.EAST );

        this.cords = new JLabel();
        getContentPane().add( this.cords, BorderLayout.NORTH );

        addMouseListener( this ); // listens for own mouse and
        addMouseMotionListener( this ); // mouse-motion events

        setSize( 800, 600 );
        setVisible( true );

    }

// MouseListener event handlers // handle event when mouse released immediately after press 
    public void mouseClicked( final MouseEvent event ) {
        this.mousePosition.setText( "Clicked at [" + event.getX() + ", " + event.getY() + "]" );

        repaint();
    }

// handle event when mouse pressed 
    public void mousePressed( final MouseEvent event ) {

        this.mousePosition.setText( "Pressed at [" + ( this.x1 = event.getX() ) + ", " + ( this.y1 = event.getY() ) + "]" );

        this.recStart.setText( "Start:  [" + this.x1 + ", " + this.y1 + "]" );

        this.isNewRect = true;

        repaint();
    }

// handle event when mouse released after dragging 
    public void mouseReleased( final MouseEvent event ) {
        this.mousePosition.setText( "Released at [" + ( this.x2 = event.getX() ) + ", " + ( this.y2 = event.getY() ) + "]" );

        this.recStop.setText( "End:  [" + this.x2 + ", " + this.y2 + "]" );

        repaint();
    }

// handle event when mouse enters area 
    public void mouseEntered( final MouseEvent event ) {
        this.mousePosition.setText( "Mouse entered at [" + event.getX() + ", " + event.getY() + "]" );
        repaint();
    }

// handle event when mouse exits area 
    public void mouseExited( final MouseEvent event ) {
        this.mousePosition.setText( "Mouse outside window" );
        repaint();
    }

// MouseMotionListener event handlers // handle event when user drags mouse with button pressed 
    public void mouseDragged( final MouseEvent event ) {
        this.mousePosition.setText( "Dragged at [" + ( this.x2 = event.getX() ) + ", " + ( this.y2 = event.getY() ) + "]" ); // call repaint which calls paint repaint();

        this.isNewRect = false;

        repaint();
    }

// handle event when user moves mouse 
    public void mouseMoved( final MouseEvent event ) {
        this.mousePosition.setText( "Moved at [" + event.getX() + ", " + event.getY() + "]" );
        repaint();
    }

    @Override
    public void paint( final Graphics g ) {
        super.paint( g ); // clear the frame surface 
        g.drawString( "Start Rec Here", this.x1, this.y1 );
        g.drawString( "End Rec Here", this.x2, this.y2 );

        int width = this.x1 - this.x2;
        int height = this.y1 - this.y2;

        this.w = Math.abs( width );
        this.h = Math.abs( height );
        this.x = width < 0 ? this.x1
            : this.x2;
        this.y = height < 0 ? this.y1
            : this.y2;

        if ( !this.isNewRect ) {
            g.drawRect( this.x, this.y, this.w, this.h );
        }

        this.cords.setText( "w = " + this.w + ", h = " + this.h );

    }

    public static void main( final String args[] ) {
        MouseTracker4July application = new MouseTracker4July();
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

} // end class MouseTracker