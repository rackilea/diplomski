import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Foo2 extends JPanel {
   private static final String[] BUTTON_TEXTS = { "A", "B", "C", "D", "E", "F",
         "G", "H", "I", "J", "K", "l" };
   private static final int GAP = 3;
   private JTextArea textArea1 = new JTextArea(20, 30);
   private JTextArea textArea2 = new JTextArea(20, 30);

   public Foo2() {
      JPanel textAreaGrid = new JPanel(new GridLayout(1, 0, GAP, GAP)); // gridlayout 1 row
      textAreaGrid.add(new JScrollPane(textArea1));
      textAreaGrid.add(new JScrollPane(textArea2));

      JPanel buttonPanel = new JPanel(new GridLayout(2, 0, GAP, GAP)); // 2 rows
      for (String btnText : BUTTON_TEXTS) {
         buttonPanel.add(new JButton(btnText));
      }

      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      setLayout(new BorderLayout(GAP, GAP)); // main GUI uses border layout
      add(textAreaGrid, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.PAGE_END);
   }

   private static void createAndShowGui() {
      Foo2 mainPanel = new Foo2();

      JFrame frame = new JFrame("Foo2");
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