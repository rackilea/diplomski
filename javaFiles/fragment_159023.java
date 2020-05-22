public class ChildFrameTest
{
    public static void main ( String[] args )
    {
        JFrame application = new JFrame ();
        application.setSize ( 600, 600 );
        application.setLocationRelativeTo ( null );
        application.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );

        JChildFrame tool = new JChildFrame ( application );
        tool.setModalExclusionType ( Dialog.ModalExclusionType.APPLICATION_EXCLUDE );
        tool.setSize ( 100, 600 );
        tool.setLocation ( application.getX () + application.getWidth (), application.getY () );

        new WindowFollowListener ( tool, application );

        application.setVisible ( true );
        tool.setVisible ( true );
    }

    public static class JChildFrame extends JFrame
    {
        public JChildFrame ( JFrame parent )
        {
            super ();
            parent.addWindowListener ( new WindowAdapter ()
            {
                public void windowClosing ( WindowEvent e )
                {
                    dispose ();
                }
            } );
        }
    }
}