import javax.swing.*;

public class Main2 {
   private static final int MAX_CELLS = 30;

   private static void createAndShowGUI() {
      final DefaultListModel<String> listModel = new DefaultListModel<>();
      final JList<String> myList = new JList<>(listModel);
      myList.setVisibleRowCount(8);

      for (int i = 0; i < MAX_CELLS; i++) {
         listModel.addElement("label22222222222222222222222222222222222222222222222222222222" + i);
      }

      JTabbedPane jTabbedPane = new JTabbedPane();

      jTabbedPane.add("Test", new JScrollPane(myList));

      JFrame frame = new JFrame("Main2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(jTabbedPane);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}