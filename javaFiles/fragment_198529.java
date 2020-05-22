import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;

import javax.swing.*;

@SuppressWarnings("serial")
public class PreferredSizeEg extends JPanel {
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;

   public PreferredSizeEg() {
      JPanel centerPanel = new JPanel(new GridBagLayout());
      centerPanel.add(new CenterImagePanel());

      JScrollPane scrollpane = new JScrollPane(new LongImagePanel(),
            JScrollPane.VERTICAL_SCROLLBAR_NEVER,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

      setLayout(new BorderLayout());
      add(centerPanel, BorderLayout.CENTER);
      add(scrollpane, BorderLayout.PAGE_END);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private class LongImagePanel extends JPanel {
      private static final int LI_PREF_W = 5000;
      private static final int LI_PREF_H = 150;

      @Override
      protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         Graphics2D g2 = (Graphics2D) g;
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);

         int index = 0;
         int spriteWidth = 50;
         while ((index) * spriteWidth < getWidth()) {
            Color c = index % 2 == 0 ? Color.green : Color.red;
            g.setColor(c);
            int x = 2 + index * spriteWidth;
            int y = 2;
            int width = getHeight() - 4;
            int height = width;
            g.fillOval(x, y, width, height);
            index++;
         }
      }

      @Override
      public Dimension getPreferredSize() {
         return new Dimension(LI_PREF_W, LI_PREF_H);
      }
   }

   private class CenterImagePanel extends JPanel {
      private static final int CIP_PREF_W = 200;
      private static final int CIP_PREF_H = CIP_PREF_W;

      public CenterImagePanel() {
         setBorder(BorderFactory.createLineBorder(Color.BLACK));
      }

      @Override
      protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         Graphics2D g2 = (Graphics2D) g;
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);
         g.setColor(Color.green);
         int x = 5;
         int y = x;
         int width = getWidth() - 2 * x;
         int height = getHeight() - 2 * y;
         g.fillOval(x, y, width, height);
      }

      @Override
      public Dimension getPreferredSize() {
         return new Dimension(CIP_PREF_W, CIP_PREF_H);
      }
   }

   private static void createAndShowGui() {
      PreferredSizeEg mainPanel = new PreferredSizeEg();

      JFrame frame = new JFrame("PreferredSizeEg");
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