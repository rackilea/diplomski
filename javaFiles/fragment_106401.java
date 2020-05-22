public class LayoutTest
{
   public static void main( String[] args )
   {
      SwingUtilities.invokeLater( new Runnable(){
         public void run()
         {
            JFrame frame = new JFrame();

            TopPanel top = new TopPanel();
            frame.add( top, BorderLayout.NORTH );
            frame.add( new JButton( "4" ) );
            frame.add( new JButton( "5" ), BorderLayout.EAST );

            frame.pack();
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            frame.setLocationRelativeTo( null );
            frame.setVisible( true );
         }
      } );
   }
}

class CenterButtonPanel extends JPanel {
   public CenterButtonPanel( String name ) {
      JButton but = new JButton( name );
      add( but );
   }
}

class TopPanel extends JPanel {
  TopPanel() {
     Box right = Box.createVerticalBox();
     right.add( new CenterButtonPanel( "2" ) );
     right.add( new CenterButtonPanel( "3" ) );
     Box left = Box.createHorizontalBox();
     left.add( new CenterButtonPanel( "1" ) );
     left.add( right );
     add( left );
  }
}