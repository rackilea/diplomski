import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class LayoutEg extends JPanel {
   private static final long serialVersionUID = 1L;
   private static final int ROWS = 30;
   private static final int COLS = 30;
   private static final int GBC_GAP = 10;
   private JTextArea textArea1 = new JTextArea(ROWS, COLS);
   private JTextArea textArea2 = new JTextArea(ROWS, COLS);
   private JButton encryptButton = new JButton("Encrypt");
   private JButton decryptButton = new JButton("Decrypt");

   public LayoutEg() {
      JPanel centerPanel = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridheight = 1;
      gbc.gridwidth = 1;
      gbc.insets = new Insets(GBC_GAP, GBC_GAP, GBC_GAP, GBC_GAP);

      // setting the weightx and weighty of 0 is what forces the buttons 
      // in the center to bunch together
      gbc.weightx = 0;  
      gbc.weighty = 0;  
      gbc.gridx = 0;
      gbc.gridy = 0;
      centerPanel.add(encryptButton, gbc);

      gbc.gridy = 1;
      centerPanel.add(decryptButton, gbc);

      setBorder(BorderFactory.createEmptyBorder(GBC_GAP, GBC_GAP, GBC_GAP, GBC_GAP));
      setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
      add(new JScrollPane(textArea1));
      add(centerPanel);
      add(new JScrollPane(textArea2));
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Layout Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new LayoutEg());
      frame.pack();
      frame.setLocationRelativeTo(null);
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