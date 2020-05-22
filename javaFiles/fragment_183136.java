import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class FutureValueFrame extends JFrame {
  public static void main( String[] args ) {
    DecimalFormat format = new DecimalFormat( "####.##" );
    //in case you always want to see the 2 fraction digits
    //format.setMinimumFractionDigits( 2 );
    final JFormattedTextField field1 = new JFormattedTextField(
        format );
    final JFormattedTextField field2 = new JFormattedTextField(
        format );
    field1.setColumns( 15 );
    field2.setColumns( 15 );
    JButton btn = new JButton( new AbstractAction( "Multiply by 2" ) {

      @Override
      public void actionPerformed( ActionEvent e ) {
        Number value = ( Number ) field1.getValue();
        if ( value != null ){
          field2.setValue( 2 * value.doubleValue() );
        }
      }
    } );

    JPanel panel = new JPanel();
    panel.add( field1 );
    panel.add( btn );
    panel.add( field2 );
    JOptionPane.showMessageDialog( null, panel );
  }
}