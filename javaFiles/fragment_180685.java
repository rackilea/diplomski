import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class DragTest2 extends JPanel {
   private static final int PREF_W = 500;
   private static final int PREF_H = 400;
   private static final float LABEL_PTS = 24f;
   private static final String LABEL_TEXT = "My Label";
   private JLabel label = null;

   public DragTest2() {
      setLayout(null);
      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      addMouseListener(myMouseAdapter);
      addMouseMotionListener(myMouseAdapter);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   class MyMouseAdapter extends MouseAdapter {

      @Override
      public void mousePressed(MouseEvent e) {
         label = new JLabel(LABEL_TEXT);
         label.setFont(label.getFont().deriveFont(LABEL_PTS));
         Dimension labelSize = label.getPreferredSize();
         label.setSize(labelSize);
         int x = e.getX() - labelSize.width / 2;
         int y = e.getY() - labelSize.height / 2;
         label.setLocation(x , y);
         add(label);
         repaint();
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         if (label != null) {
            Dimension labelSize = label.getPreferredSize();
            int x = e.getX() - labelSize.width / 2;
            int y = e.getY() - labelSize.height / 2;
            label.setLocation(x , y);
            repaint();
         }
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         if (label != null) {
            Dimension labelSize = label.getPreferredSize();
            int x = e.getX() - labelSize.width / 2;
            int y = e.getY() - labelSize.height / 2;
            label.setLocation(x , y);
            repaint();
            label = null;
         }
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("DragTest2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new DragTest2());
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