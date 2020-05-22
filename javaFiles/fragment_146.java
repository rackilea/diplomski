public class GiraffeMouseHandler extends MouseAdapter implements MouseMotionListener
{

    public void mouseEntered( MouseEvent event )
    {
        status.setText( "Entered" );
    }

    public void mouseExited( MouseEvent event )
    {
        status.setText( "Exited" ); 
    }

    public void mouseMoved( MouseEvent event )
    {
        //dimension is a reference of dimension of the main frame
        if( ( dimension.getHeight() - event.getY() ) < 65 )
            status.setBounds( event.getX(), (int)dimension.getHeight() - 65 , 50, 60 );
        else if( ( dimension.getWidth() - event.getX() ) < 50 )
            status.setBounds( (int)dimension.getWidth() - 50, event.getY(), 50, 60 );
        else
            status.setBounds( event.getX(), event.getY(), 50, 60 );         
    }

}