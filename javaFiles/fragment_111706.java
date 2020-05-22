private void hackyToFront( )
{
    // What follows is a hack to make sure that the frame is put to front and activated.
    // Simply calling setVisible( true ) and toFront( ) is not enough.

    SwingUtilities.invokeLater( new Runnable( )
    {
        @Override
        public void run( )
        {
            if( !isVisible( ) )
                setVisible( true );
            setExtendedState( JFrame.NORMAL );
            toFront( );
            setAlwaysOnTop( true );
            try
            {
                final Point oldMouseLocation = MouseInfo.getPointerInfo( ).getLocation( );

                // simulate a mouse click on title bar of window
                Robot robot = new Robot( );
                robot.mouseMove( getX( ) + 100, getY( ) + 10 );
                robot.mousePress( InputEvent.BUTTON1_DOWN_MASK );
                robot.mouseRelease( InputEvent.BUTTON1_DOWN_MASK );

                // move mouse to old location
                robot.mouseMove( (int) oldMouseLocation.getX( ), (int) oldMouseLocation.getY( ) );
            }
            catch( Exception ex )
            {}
            finally
            {
                setAlwaysOnTop( false );
            }
        }
    } );
}