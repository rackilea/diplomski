import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboboxTest {

  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame( "TestFrame" );
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Item1", "Item2"});
        final String browse = "<<BROWSE>>";
        comboBox.addItem( browse );
        comboBox.addItemListener( new ItemListener() {
          @Override
          public void itemStateChanged( ItemEvent e ) {
            if ( e.getStateChange() == ItemEvent.SELECTED && 
                browse.equals( e.getItem() ) ){
              System.out.println("Show filechooser");
            }
          }
        } );
        frame.add( comboBox );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
        frame.pack();
      }
    } );
  }
}