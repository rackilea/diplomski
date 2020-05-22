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

    JSlider slider = new JSlider ( SwingConstants.VERTICAL );
    slider.setPaintLabels ( true );
    slider.setComponentOrientation ( ComponentOrientation.RIGHT_TO_LEFT );

    Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel> ();
    table.put ( 0, new JLabel ( "May 2, 2000" ) );
    table.put ( 25, new JLabel ( "May 3, 2001" ) );
    table.put ( 50, new JLabel ( "May 4, 2002" ) );
    table.put ( 75, new JLabel ( "May 5, 2003" ) );
    table.put ( 100, new JLabel ( "May 6, 2004" ) );
    slider.setLabelTable ( table );

    frame.add ( slider );

    frame.pack ();
    frame.setLocationRelativeTo ( null );
    frame.setVisible ( true );
}