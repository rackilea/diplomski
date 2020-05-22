public class Main extends JFrame {

// Attibute version
// private final JTextField textfield = new JTextField( "0000" );

   Main() {
      super( "Hello, scrollbars!" );
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      setLayout( new BoxLayout( getContentPane(), BoxLayout.Y_AXIS ));

      // this variable may be defined as attribute
      final JTextField textfield = new JTextField( "0000" );
      add( textfield );

      final JScrollPane scrollPane =
         new JScrollPane(
            new JList<>(
               new String[]{
                  "Hello", "Scrollbars",
                  "Hello", "Scrollbars",
                  "Hello", "Scrollbars",
                  "Hello", "Scrollbars",
                  "Hello", "Scrollbars",
               }));
      scrollPane.getVerticalScrollBar().addAdjustmentListener(
         e -> textfield.setText( String.format( "%04d", e.getValue())));
      add( scrollPane );

      pack();
      setLocationRelativeTo( null );
      setVisible( true );
   }

   public static void main( String[] args ) {
      new Main();
   }
}