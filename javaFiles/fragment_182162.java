import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class Name2 extends JPanel {
   private static final int GAP = 5;

   public Name2() {
      JPanel topPanel = new JPanel();
      topPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
      topPanel.add(new JButton("Choose File to Open"));

      JTextPane textPane = new JTextPane() {
         public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(750, 600);
         };
      };

      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

      add(topPanel);
      add(Box.createVerticalStrut(GAP));
      add(new JScrollPane(textPane));
      add(Box.createVerticalStrut(GAP));
      add(new JTextField());
   }

   private static void createAndShowGui() {
      Name2 mainPanel = new Name2();

      JFrame frame = new JFrame("Name2");
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