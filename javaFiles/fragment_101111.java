import javax.swing.JComboBox;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmptyComboboxTest {
  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        JComboBox<String> emptyBox = new JComboBox<String>();
        emptyBox.addActionListener( new ActionListener() {
          @Override
          public void actionPerformed( ActionEvent e ) {
            Thread.dumpStack();
          }
        } );
        emptyBox.addItem( "test" );
      }
    } );
  }
}