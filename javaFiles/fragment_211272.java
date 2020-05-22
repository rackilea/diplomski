public class MainScreen extends JFrame
{
    public JPanel comboPanel;
    public JComboBox cardCombo;

    public CardLayout cardLayout;
    public JPanel cardContainer;

    public static ImageIcon background =
            new ImageIcon ( MainScreen.class.getResource ( "icons/title.png" ) );

    public MainScreen ()
    {
        super ();
        setTitle ( "Project" );

        comboPanel = new JPanel ();
        cardCombo = new JComboBox ();

        cardLayout = new CardLayout ();
        cardContainer = new BackgroundPanel ( cardLayout );
        cardContainer.setOpaque ( true );
        cardContainer.setBackground ( Color.BLACK );
        getContentPane ().add ( cardContainer, BorderLayout.CENTER );

        initializeGUI ();

        setSize ( 800, 600 );
        setResizable ( false );
        setLocationRelativeTo ( null );
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        setVisible ( true );
    }

    public void initializeGUI ()
    {
        JPanel debugPanel = new JPanel ( new BorderLayout () );
        debugPanel.setOpaque ( false );
        String debug = "Debug Panel";
        cardContainer.add ( debugPanel, debug );
        cardCombo.addItem ( debug );

        JPanel titlePanel = new JPanel ( new BorderLayout () );
        titlePanel.setOpaque ( false );
        String title = "Title Panel";
        cardContainer.add ( titlePanel, title );
        cardCombo.addItem ( title );

        cardLayout.show ( cardContainer, title );
    }

    private class BackgroundPanel extends JPanel
    {
        public BackgroundPanel ( LayoutManager layout )
        {
            super ( layout );
        }

        protected void paintComponent ( Graphics g )
        {
            super.paintComponent ( g );
            g.drawImage ( background.getImage (), 0, 0, BackgroundPanel.this );
        }
    }

    public static void main ( String[] args )
    {
        new MainScreen ();
    }
}