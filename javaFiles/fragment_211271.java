public MainScreen ()
{
    super();
    setTitle ( "Project" );//Title of the screen
    setSize ( 800, 600 );//Size of the window
    setResizable ( false );//Is the window resizable?
    setDefaultCloseOperation (
            JFrame.EXIT_ON_CLOSE );//Exit the frame when the default red cross is clicked
    setVisible ( true );//is the frame visible?
    getContentPane ()
            .add ( cardContainer, BorderLayout.CENTER );//add the cardcontainer to flip panels
    setLocationRelativeTo ( null );
    repaint (  );
}