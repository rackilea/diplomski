public static void main ( String[] args )
{
    JFrame frame = new JFrame ();

    final DefaultListModel model = new DefaultListModel ();

    JList list = new JList ( model );
    frame.add ( new JScrollPane ( list ) );

    list.addMouseListener ( new MouseAdapter ()
    {
        public void mousePressed ( MouseEvent e )
        {
            model.clear ();
            Random random = new Random ();
            int max = random.nextInt ( 10 );
            for ( int i = 0; i <= max; i++ )
            {
                model.addElement ( "" + random.nextInt ( 100 ) );
            }
        }
    } );

    frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
    frame.setSize ( 200, 400 );
    frame.setLocationRelativeTo ( null );
    frame.setVisible ( true );
}