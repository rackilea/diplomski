import java.awt.Dimension;
import javax.swing.*;

public class Foo001 {

   private static void createAndShowUI() {
      DefaultListModel model = new DefaultListModel();
      JList sList = new JList(model);
      for (int i = 0; i < 100; i++) {
         model.addElement("String " + i);
      }

      sList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      sList.setVisibleRowCount(-1);
      sList.setLayoutOrientation(JList.HORIZONTAL_WRAP);

      JFrame frame = new JFrame("Foo001");
      frame.getContentPane().add(new JScrollPane(sList));
      frame.getContentPane().setPreferredSize(new Dimension(400, 300));
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