import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class Test3 extends JPanel {
   private static final int BTN_COUNT = 20;
   private static final int GAP = 5;
   private static final Color BG = Color.RED;

   public Test3() {
      JPanel btnPanel = new JPanel(new GridLayout(0, 4, GAP, GAP));
      for (int i = 0; i < BTN_COUNT; i++) {
         btnPanel.add(new JButton(String.valueOf(i + 1)));
      }
      btnPanel.setOpaque(false);

      JPanel southPanel = new JPanel(new GridLayout(1, 0, GAP, 0));
      southPanel.add(new JButton("Previous"));
      southPanel.add(new JButton("Next"));
      southPanel.setOpaque(false);

      setBackground(BG);
      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      setLayout(new BorderLayout(GAP, GAP));
      add(btnPanel, BorderLayout.CENTER);
      add(southPanel, BorderLayout.PAGE_END);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Test3");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Test3());
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