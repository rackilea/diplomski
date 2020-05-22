import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MineSweeper {
   private JPanel mainPanel = new JPanel();
   private MineCellGrid mineCellGrid;
   private JButton resetButton = new JButton("Reset");

   public MineSweeper(int rows, int cols, int mineTotal) {
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
      mineCellGrid = new MineCellGrid(rows, cols, mineTotal);

      resetButton.setMnemonic(KeyEvent.VK_R);
      resetButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            mineCellGrid.reset();
         }
      });

      mainPanel.add(mineCellGrid);
      mainPanel.add(new JSeparator());
      mainPanel.add(new JPanel(){{add(resetButton);}});
   }

   private JPanel getMainPanel() {
      return mainPanel;
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("MineSweeper");
      //frame.getContentPane().add(new MineSweeper(20, 20, 44).getMainPanel());
      frame.getContentPane().add(new MineSweeper(12, 12, 13).getMainPanel());
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