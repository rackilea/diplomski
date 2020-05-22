import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JavaDemo extends JPanel {

  public JavaDemo() {
    setLayout(new GridLayout(2, 1));
    JList lista = new JList(new String[] {"1", "2", "3", "4"});
    add(new JScrollPane(lista));
    JComboBox combo = new JComboBox();
    for (int i = 0; i < 100; i++) {
      combo.addItem(Integer.toString(i));
      add(combo);
    }
  }

  public static void main(String args[]) {
    JavaDemo lista = new JavaDemo();
    JFrame ventana = new JFrame();
    ventana.getContentPane().add(lista, BorderLayout.CENTER);
    ventana.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        System.exit(0);
      }
    });
    ventana.setSize(200, 200);
    ventana.setVisible(true);
  }
}