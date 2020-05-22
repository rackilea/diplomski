import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class GridBagExample extends JPanel {

   public GridBagExample() {
      setLayout(new GridBagLayout());

      add(new JButton("Refresh"), createGbc(0, 0));
      add(new JScrollPane(new JTextArea(12, 20)), createGbc(1, 0, 5, 1));


      for (int i = 0; i < 6; i++) {
         String text = "Button: " + (10 - i); 
         JButton button = new JButton(text);
         add(button, createGbc(i, 1));
      }
   }

   private GridBagConstraints createGbc(int x, int y) {
      return createGbc(x, y, 1, 1);
   }

   private GridBagConstraints createGbc(int x, int y, int w, int h) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = w;
      gbc.gridheight = h;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = new Insets(2, 2, 2, 2);
      return gbc;
   }

   private static void createAndShowGui() {
      GridBagExample mainPanel = new GridBagExample();

      JFrame frame = new JFrame("GridBagExample");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}