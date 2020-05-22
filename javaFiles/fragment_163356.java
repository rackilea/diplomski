import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Chooser extends JPanel {
   private static final String[] BUTTON_TEXTS = { "Hello", "Goodbye",
         "Hello Goodbye", "Adios", "This is a long String for WTF" };

   public Chooser() {
      this.setLayout(new BorderLayout());

      JPanel labelPanel = new JPanel();
      JLabel label = new JLabel("Choose a file:");
      labelPanel.add(label);
      labelPanel.setBackground(Color.red);

      JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
      for (int i = 0; i < BUTTON_TEXTS.length; i++) {
         buttonPanel.add(new JButton(BUTTON_TEXTS[i]));
      }
      buttonPanel.add(Box.createVerticalGlue()); // to pad the bottom if needed
      buttonPanel.setBackground(Color.blue);

      this.add(labelPanel, BorderLayout.PAGE_START);
      this.add(new JScrollPane(buttonPanel), BorderLayout.CENTER);
   }

   public static void main(String[] args) {
      Chooser c = new Chooser();
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setAccessory(c);
      fileChooser.showOpenDialog(null);
   }

}