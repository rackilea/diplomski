public static void main ( String[] args )
{
    try
    {
        UIManager.setLookAndFeel ( new NimbusLookAndFeel () );
    }
    catch ( UnsupportedLookAndFeelException e )
    {
        e.printStackTrace ();
    }


    JFrame frame = new JFrame ();
    frame.getRootPane ().setBorder ( BorderFactory.createEmptyBorder ( 5, 5, 5, 5 ) );

    JSlider slider = new JSlider ( SwingConstants.HORIZONTAL );
    slider.setPaintLabels ( true );

    Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel> ();
    table.put ( 0, new JLabel ( "May 2, 2000" ) );
    JLabel l2 = new JLabel ( "May 3, 2001" );
    l2.setBorder ( BorderFactory.createEmptyBorder ( 20, 0, 0, 0 ) );
    table.put ( 25, l2 );
    table.put ( 50, new JLabel ( "May 4, 2002" ) );
    JLabel l3 = new JLabel ( "May 5, 2003" );
    l3.setBorder ( BorderFactory.createEmptyBorder ( 20, 0, 0, 0 ) );
    table.put ( 75, l3 );
    table.put ( 100, new JLabel ( "May 6, 2004" ) );
    slider.setLabelTable ( table );

    frame.add ( slider );

    frame.pack ();
    frame.setLocationRelativeTo ( null );
    frame.setVisible ( true );
}