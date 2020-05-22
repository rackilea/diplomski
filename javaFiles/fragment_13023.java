public class MyFrame extends JFrame
{
    public MyFrame ()
    {
        super();

        // Add components first
        initComponents ();

        // Setup frame after so it fits its new content
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        setPreferredSize ( new Dimension ( 500, 300 ) );
        setResizable ( false );
        pack ();
        setLocationRelativeTo ( null );
    }

    private void initComponents ()
    {
        JPanel panel = new JPanel ();
        panel.setLayout ( new BoxLayout ( panel, BoxLayout.Y_AXIS ) );

        for ( int i = 0; i < 100; i++ )
        {
            panel.add ( new JLabel ( "some text" ) );
        }

        JScrollPane scrollPane =
                new JScrollPane ( panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );

        // Here I create a JPanel to replace the contentPane of JFrame
        JPanel contentPane = new JPanel ();
        contentPane.add ( scrollPane );
        setContentPane ( contentPane );
    }

    public static void main ( String[] args )
    {
        SwingUtilities.invokeLater ( new Runnable ()
        {
            public void run ()
            {
                new MyFrame ().setVisible ( true );
            }
        } );
    }
}