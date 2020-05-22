import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import org.japura.gui.Anchor;
import org.japura.gui.Decorator;
import org.japura.gui.Decorator.Direction;
import org.japura.gui.Images;


public class DecoratorExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    ImageIcon icon = new ImageIcon(Images.CALENDAR); 
    JTextArea field1 = new JTextArea(4,10);
    JTextArea field2 = new JTextArea(4,10);    
    Decorator decorator1 = new Decorator(field1, Anchor.SOUTH_EAST, Direction.VERTICAL);
    decorator1.addDecoration(icon);
    decorator1.addDecoration(icon);
    // removing a decoration
    decorator1.addDecoration("name", icon);
    decorator1.removeDecoration("name");    
    Decorator decorator2= new Decorator(field2, Anchor.EAST);
    decorator2.addDecoration(icon);
    decorator2.setMargin(new Insets(0,0,0,10)); 
    JPanel panel = new JPanel();
    panel.add(decorator1);
    panel.add(decorator2);    
    frame.add(panel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}