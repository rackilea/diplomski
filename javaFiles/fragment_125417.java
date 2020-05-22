import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class TestDrawing extends JPanel {
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;
   private DrawingPanel drawingPanel = new DrawingPanel();

   public TestDrawing() {
      JPanel northPanel = new JPanel();
      northPanel.add(new JButton(new AbstractAction("Draw Lines") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            drawingPanel.drawLines();
            drawingPanel.repaint();
         }
      }));

      setLayout(new BorderLayout());
      add(new JScrollPane(drawingPanel));
      add(northPanel, BorderLayout.PAGE_START);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      TestDrawing mainPanel = new TestDrawing();

      JFrame frame = new JFrame("TestDrawing");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

class DrawingPanel extends JPanel {
   private static final int BI_W = 500;
   private static final int FLOOR = 22;
   private static final int FLO_H = 100;
   private BufferedImage img = new BufferedImage(BI_W, FLO_H * FLOOR, BufferedImage.TYPE_INT_ARGB);

   public DrawingPanel() {

   }

   public void drawLines() {

      Graphics g = img.getGraphics();
      g.setColor(Color.black);
      for (int i = 0; i < FLOOR; i++) {
         g.drawLine(0, i * FLO_H, 300, i * FLO_H);
         g.setColor(Color.RED);
      }
      g.dispose();
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(BI_W, FLO_H * FLOOR);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (img != null) {
         g.drawImage(img, 0, 0, this);
      }
   }
}