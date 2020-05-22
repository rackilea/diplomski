public static void main ( String[] args )
{
    final JFrame frame = new JFrame ();

    // Some content
    frame.getContentPane ().setLayout ( new FlowLayout ( FlowLayout.CENTER, 5, 5 ) );
    frame.getContentPane ().add ( new JButton ( "Test" ) );
    frame.getContentPane ().add ( new JLabel ( "Test" ) );
    frame.getContentPane ().add ( new JTextField ( "Test" ) );

    // Global mouse listener
    final AWTEventListener listener = new AWTEventListener ()
    {
        public void eventDispatched ( AWTEvent event )
        {
            // Event and component that recieved that event
            MouseEvent me = ( MouseEvent ) event;
            Component c = me.getComponent ();

            // Ignoring mouse events from any other frame
            if ( SwingUtilities.getWindowAncestor ( c ) == frame )
            {
                if ( event.getID () == MouseEvent.MOUSE_PRESSED )
                {
                    System.out.println ( "Mouse pressed on " + c.getClass ().getCanonicalName () );
                }
                if ( event.getID () == MouseEvent.MOUSE_RELEASED )
                {
                    System.out.println ( "Mouse released on " + c.getClass ().getCanonicalName () );
                }
                if ( event.getID () == MouseEvent.MOUSE_ENTERED )
                {
                    System.out.println ( "Mouse entered " + c.getClass ().getCanonicalName () );
                }
                if ( event.getID () == MouseEvent.MOUSE_EXITED )
                {
                    System.out.println ( "Mouse exited " + c.getClass ().getCanonicalName () );
                }
            }
        }
    };
    Toolkit.getDefaultToolkit ().addAWTEventListener ( listener, AWTEvent.MOUSE_EVENT_MASK );

    frame.pack ();
    frame.setLocationRelativeTo ( null );
    frame.setVisible ( true );
}