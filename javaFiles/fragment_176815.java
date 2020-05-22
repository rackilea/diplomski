import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class TheProblem2 {
   private static void createAndShowGUI() {
      int rows = 5;
      int cols = 20;
      JTextArea textArea = new JTextArea(rows, cols);
      JScrollPane scrollPane = new JScrollPane(textArea);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

      JButton button1 = new JButton("Button 1");
      JButton button2 = new JButton("Button 1");
      JPanel btnPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      btnPanel.add(button1);
      btnPanel.add(button2);

      JPanel mainPanel = new JPanel(new BorderLayout());
      mainPanel.add(scrollPane);
      mainPanel.add(btnPanel, BorderLayout.SOUTH);

      JFrame frame = new JFrame("EG 2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
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