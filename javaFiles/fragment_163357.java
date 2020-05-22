import java.awt.*;
import java.io.File;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Chooser extends JPanel {
   private static final String[] BUTTON_TEXTS = { "Hello", "Goodbye",
         "Hello Goodbye", "Adios", "This is a long String for WTF", "Hello",
         "Goodbye", "Hello Goodbye", "Adios", "This is a long String for WTF" };

   public Chooser(final JFileChooser fileChooser) {
      setLayout(new BorderLayout());

      JPanel labelPanel = new JPanel();
      JLabel label = new JLabel("Choose a file:");
      labelPanel.add(label);
      labelPanel.setBackground(Color.red);

      final JList list = new JList(BUTTON_TEXTS);
      list.addListSelectionListener(new ListSelectionListener() {
         public void valueChanged(ListSelectionEvent e) {
            String selectedString = list.getSelectedValue().toString();
            fileChooser.setSelectedFile(new File(selectedString));
         }
      });

      add(labelPanel, BorderLayout.PAGE_START);
      add(new JScrollPane(list), BorderLayout.CENTER);
   }

   public static void main(String[] args) {
      JFileChooser fileChooser = new JFileChooser();
      Chooser c = new Chooser(fileChooser);
      fileChooser.setAccessory(c);
      fileChooser.showOpenDialog(null);
   }

}