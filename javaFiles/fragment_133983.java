import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI3 extends JPanel {
   private static final String[] COLS = { "Foo", "Bar", "Baz" };
   private static final int ROWS = 5;
   private DefaultTableModel tableModel = new DefaultTableModel(COLS, ROWS);
   private JTable table = new JTable(tableModel);
   private ResetAction resetAction = new ResetAction("Reset", KeyEvent.VK_R);
   private RandomizeAction randomizeAxn = new RandomizeAction("Randomize",
         KeyEvent.VK_Z);

   public GUI3() {
      JPanel btnPanel = new JPanel();
      btnPanel.add(new JButton(resetAction));
      btnPanel.add(new JButton(randomizeAxn));

      setLayout(new BorderLayout());
      add(new JScrollPane(table));
      add(btnPanel, BorderLayout.PAGE_END);
   }

   private class ResetAction extends AbstractAction {
      public ResetAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         tableModel.setRowCount(0);
      }
   }

   private class RandomizeAction extends AbstractAction {
      private Random random = new Random();

      public RandomizeAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      public void actionPerformed(ActionEvent e) {
         tableModel.setRowCount(ROWS);
         int rows = ROWS;
         int columns = tableModel.getColumnCount();
         for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
               int data = random.nextInt(10);
               tableModel.setValueAt(data, row, col);
            }
         }
      };
   }

   private static void createAndShowGui() {
      GUI3 mainPanel = new GUI3();

      JFrame frame = new JFrame("GUI3");
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