class T2 {

   private JFrame jf;
   private JLabel jL;
   private JButton b1, b2;
   private JRadioButton jr1;
   private JTextField tf1, tf2;
   private Font ft;

   public void run() {
      //JFrame
      jf = new JFrame( "Program" );
      jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//      jf.setVisible( true ); // don't do this until the frame is composed
//      jf.setLayout( null );   // yucky in all respects
//      jf.setBounds( 0, 40, 500, 500 ); // use setSize() instead

      //Container
//      Container c = jf.getContentPane();  // normally you just call add()

      //Font
      ft = new Font( "Consolas", 1, 25 );

      // Make panel first         
      JPanel panelNorth = new JPanel();

      //JLABEL
      jL = new JLabel();
      jL.setText( "Enter Name:" );
      jL.setFont( ft );
      panelNorth.add( jL );
      //Top-Bottom Positioning isn't working here..
//      jL.setBounds( 50, 0, 600, 600 );

      //JTextField
      tf1 = new JTextField( "Type here..." );
//      c.add( tf1 );
      panelNorth.add( tf1 );
//      tf1.setBounds( 200, 0, 200, 20 );

      // now just add the panel to the "north" of the jframe border layout
      jf.add( panelNorth, BorderLayout.NORTH );

      // now make visible
      jf.setSize( 600, 480 );
      jf.setLocationRelativeTo( null );
      jf.setVisible( true );
   }

   public static void main( String args[] ) {

      // Swing is not thread safe, do on EDT
      SwingUtilities.invokeLater( new Runnable() {
         @Override
         public void run() {
            T2 obj = new T2();
            obj.run();
         }
      } );
   }
}