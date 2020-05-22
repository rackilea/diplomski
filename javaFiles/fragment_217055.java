import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class AutoCloseFrameDemo {
  public static void main( String[] args ) {
    final JFrame frame = new JFrame( "Test" );

    KeyboardFocusManager.getCurrentKeyboardFocusManager().
        addVetoableChangeListener( "focusedWindow",
                                   new VetoableChangeListener() {
                                     private boolean gained = false;

                                     @Override
                                     public void vetoableChange( PropertyChangeEvent evt ) throws PropertyVetoException {
                                       if ( evt.getNewValue() == frame ) {
                                         gained = true;
                                       }
                                       if ( gained && evt.getNewValue() != frame ) {
                                         frame.dispose();
                                       }
                                     }
                                   } );

    frame.add( new JTextField( 10 ), BorderLayout.NORTH );
    frame.add( new JTextField( 10 ), BorderLayout.SOUTH );

    frame.pack();
    frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    frame.setVisible( true );
  }
}