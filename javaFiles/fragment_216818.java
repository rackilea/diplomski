import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class TestComponentAt extends JPanel {
   private static final int ROW_COUNT = 10;
   private static final int W = 60;
   private static final int H = W;
   private static final Dimension PREF_SIZE = new Dimension(W, H);
   protected static final Color SELECTION_COLOR = Color.pink;
   private JPanel selectedPanel = null;
   private Color originalColor = null;

   public TestComponentAt() {
      setLayout(new GridLayout(ROW_COUNT, ROW_COUNT, 1, 1));
      setBackground(Color.black);
      for (int i = 0; i < ROW_COUNT * ROW_COUNT; i++) {
         JPanel panel = new JPanel();
         String name = String.format("[%d, %d]", 
               i / ROW_COUNT, i % ROW_COUNT);
         panel.setName(name);
         if (i == 0) {
            originalColor = panel.getBackground();
         }
         panel.setPreferredSize(PREF_SIZE);
         add(panel);
      }
      addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            JPanel panel = (JPanel) getComponentAt(e.getPoint());
            if (panel == null || panel == TestComponentAt.this) {
               return;
            }
            if (selectedPanel != null) {
               selectedPanel.setBackground(originalColor);
               selectedPanel.removeAll();
               selectedPanel.revalidate();
               selectedPanel.repaint();
            }
            selectedPanel = panel;
            selectedPanel.setBackground(SELECTION_COLOR);
            selectedPanel.add(new JLabel(selectedPanel.getName()));
            selectedPanel.revalidate();
            selectedPanel.repaint();
         }
      });
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("TestComponentAt");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new TestComponentAt());
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