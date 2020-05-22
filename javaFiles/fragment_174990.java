public class SmileyTest
{
    private static Color bg = new Color ( 0, 0, 255, 128 );
    private static float angle = 0f;

    public static void main ( String[] args )
    {
        final ImageIcon icon = new ImageIcon ( SmileyTest.class.getResource ( "icons/smiley.png" ) );

        JDialog frame = new JDialog ();
        frame.setLayout ( new BorderLayout () );

        // We should not use default background and opaque panel - that might cause repaint problems
        // This is why we use JPanel with transparent background painted and opacity set to false
        JPanel transparentPanel = new JPanel ( new BorderLayout () )
        {
            protected void paintComponent ( Graphics g )
            {
                super.paintComponent ( g );
                g.setColor ( bg );
                g.fillRect ( 0, 0, getWidth (), getHeight () );
            }
        };
        transparentPanel.setOpaque ( false );
        frame.add ( transparentPanel );

        // Image in another component
        final JComponent component = new JComponent ()
        {
            protected void paintComponent ( Graphics g )
            {
                super.paintComponent ( g );

                Graphics2D g2d = ( Graphics2D ) g;

                // For better image quality when it is rotated
                g2d.setRenderingHint ( RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR );

                // Rotating area using image middle as rotation center
                g2d.rotate ( angle * Math.PI / 180, getWidth () / 2, getHeight () / 2 );

                // Transparency for image
                g2d.setComposite ( AlphaComposite.getInstance ( AlphaComposite.SRC_OVER, 0.5f ) );

                // Draing image
                g2d.drawImage ( icon.getImage (), 0, 0, null );
            }
        };
        transparentPanel.add ( component );

        // Rotation animation (24 frames per second)
        new Timer ( 1000 / 48, new ActionListener ()
        {
            public void actionPerformed ( ActionEvent e )
            {
                angle += 0.5f;
                component.repaint ();
            }
        } ).start ();

        frame.setUndecorated ( true );
        AWTUtilities.setWindowOpaque ( frame, false );
        frame.setSize ( icon.getIconWidth (), icon.getIconHeight () );
        frame.setLocationRelativeTo ( null );
        frame.setVisible ( true );
    }
}