public class Test {
  public static void main( String[] args ) {
    try {
      SwingUtilities.invokeAndWait( new Runnable() {
        public void run() {
          JFrame frame = new JFrame( "TestFrame" );
          frame.getContentPane().setLayout( new BorderLayout(  ) );
          DefaultListModel listModel = new DefaultListModel();
          listModel.addElement("Jane Doe");
          listModel.addElement("John Smith");
          listModel.addElement("Kathy Green");
          final JList list = new JList( listModel );
          list.setSelectedIndex( 0 );
          frame.getContentPane().add( list, BorderLayout.CENTER );
          JButton clearSelectionButton = new JButton( "Clear selection" );
          frame.getContentPane().add( clearSelectionButton, BorderLayout.SOUTH );

          clearSelectionButton.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent aActionEvent ) {
              list.clearSelection();
            }
          } );

          frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
          frame.pack();
          frame.setVisible( true );
        }
      } );
    } catch ( InterruptedException e ) {
    } catch ( InvocationTargetException e ) {
    }
  }
}