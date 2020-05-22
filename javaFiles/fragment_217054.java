import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AutoCloseFrameDemo {
  public static void main( String[] args ) {
    final JFrame frame = new JFrame( "Test" );
    frame.addFocusListener( new FocusListener() {
      private boolean gained = false;
      @Override
      public void focusGained( FocusEvent e ) {
        gained = true;
      }

      @Override
      public void focusLost( FocusEvent e ) {
        if ( gained ){
          frame.dispose();
        }
      }
    } );
    frame.add( new JLabel( "testlabel" ) );

    frame.pack();
    frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    frame.setVisible( true );
  }
}