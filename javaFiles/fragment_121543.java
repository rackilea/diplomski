import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ComboBoxDemo extends JFrame {
public ComboBoxDemo() {

  super("JComboBox Demo");

    String [] string = {"city","town","country","province"};
  java.util.List<String> list = new ArrayList<String>(Arrays.asList(string));


 Object[] arrayObject= list.toArray();
 String [] data = Arrays.copyOf(arrayObject, arrayObject.length,String[].class); // java 1.6+
 JComboBox<String> combo = new JComboBox<>( data);

    setLayout(new FlowLayout(FlowLayout.CENTER));
    add(combo, BorderLayout.CENTER);      
}

 public static void main(String[] args) {
      ComboBoxDemo g = new ComboBoxDemo();
    g.setVisible(true);
    g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    g.setBounds(100, 100, 300, 300);
 }
 }