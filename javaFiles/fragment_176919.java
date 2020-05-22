public class AwesomeAnswer {

  public static void main(String[] args) {
     // please not that this is only an example and not a 
     // Swing thread safe way of starting a JFrame
     JFrame frame = new JFrame();

     JPanel content = (JPanel)frame.getContentPane();
     // create our top panel that will hold all of the inserted panels
     JPanel page = new JPanel();
     page.setLayout( new BoxLayout( page, BoxLayout.Y_AXIS ) );
     // add our page to the frame content pane
     content.add( page );
     // add two button/label panels
     page.add( insert( "This is an awesome answer", "Accept" ) );
     page.add( insert( "Say thank you", "Thank" ) );


     frame.pack();
     frame.setVisible( true );
  }

  public static final JPanel insert( String labelText, String buttonText ) {
     // create the label and the button
     JLabel lbl = new JLabel( labelText );
     JButton btn = new JButton( buttonText );
     // create the panel that will hold the label and the button
     JPanel wrapPanel = new JPanel( new GridBagLayout() );
     wrapPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
     // tell the grid bag how to behave
     GridBagConstraints gbc = new GridBagConstraints();
     gbc.gridwidth = 0;
     gbc.gridheight = 2;

     // make the button centered
     JPanel buttonPanel = new JPanel( new FlowLayout( 0, 0, FlowLayout.CENTER ) );
     buttonPanel.add( btn );

     // make the label centered
     JPanel labelPanel = new JPanel( new FlowLayout( 0, 0, FlowLayout.CENTER ) );
     labelPanel.add( lbl );

     // add our button and label to the grid bag with our constraints
     wrapPanel.add( buttonPanel, gbc );
     wrapPanel.add( labelPanel, gbc );

     return wrapPanel;
  }
}