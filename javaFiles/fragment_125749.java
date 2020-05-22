import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class LabelTest extends JPanel {
   public LabelTest() {
      add(new MyLabel("Fubar!"));
   }

   private static void createAndShowGui() {
      LabelTest mainPanel = new LabelTest();

      JFrame frame = new JFrame("LabelTest");
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

@SuppressWarnings("serial")
class MyLabel extends JLabel {
   private static final Color BACKGROUND_DEFAULT = new Color(200, 200, 255);
   private static final Color BACKGROUND_MOUSEOVER = new Color(255, 200, 200);
   private static final int PREF_W = 200;
   private static final int PREF_H = 100;

   public MyLabel(String text) {
      super(text, SwingConstants.CENTER);
      setOpaque(true);
      setBackground(BACKGROUND_DEFAULT);
      addMouseListener(new MouseAdapter() {

         @Override
         public void mouseEntered(MouseEvent arg0) {
            setBackground(BACKGROUND_MOUSEOVER);
         }

         @Override
         public void mouseExited(MouseEvent e) {
            setBackground(BACKGROUND_DEFAULT);
         }

      });
   }

   @Override
   public Dimension getPreferredSize() {
      int width = Math.max(super.getPreferredSize().width, PREF_W);
      int height = Math.max(super.getPreferredSize().height, PREF_H);
      return new Dimension(width, height);
   }
}