import java.awt.BorderLayout;
import javax.swing.*;

public class JComboAndJTextArea extends JPanel {

   private static final String[] ITEMS1 = {"one", "two", "three", "four", "five"};
   private static final String[] ITEMS2 = {"Monday", "Tuesday", 
      "Wednesday", "Thursday", "Friday"};

   public JComboAndJTextArea() {
      JPanel northPanel = new JPanel();
      northPanel.add(new JCheckBox("Reminder"));
      northPanel.add(new JComboBox(ITEMS1));
      northPanel.add(new JComboBox(ITEMS2));

      setLayout(new BorderLayout());
      add(northPanel, BorderLayout.NORTH);
      add(new JScrollPane(new JTextArea(8, 30)), BorderLayout.CENTER);

   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("JComboAndJTextArea");
      frame.getContentPane().add(new JComboAndJTextArea());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}