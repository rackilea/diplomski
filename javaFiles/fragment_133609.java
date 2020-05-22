import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Sandbox {
   public static void main(String[] args) {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      JPanel panel = new JPanel();
      frame.add(panel);
      WideComponent wc = new WideComponent();
      JButton button = new JButton("Test");

      wc.setBorder(createBorder());
      button.setBorder(createBorder());

      panel.add(wc);
      panel.add(button);

      frame.add(panel);
      frame.setVisible(true);
      frame.pack();
   }

   private static Border createBorder() {
      Border innerBorder = BorderFactory.createLineBorder(Color.red);
      int eb = 50;
      Border outerBorder = BorderFactory.createEmptyBorder(eb, eb, eb, eb);
      Border comboBorder = BorderFactory.createCompoundBorder(outerBorder,
            innerBorder);
      return comboBorder;
   }
}

class WideComponent extends JComponent {
   final int WIDTH = 500;
   final int HEIGHT = 150;

   public WideComponent() {
      setOpaque(true);
   }

   // drawing method
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
       g.setColor(Color.BLUE);
       g.fillRect(0, 0, WIDTH, HEIGHT);
   }

   // JComponent sizing methods
   public Dimension getPreferredSize() {
      return new Dimension(WIDTH, HEIGHT);
   }

   public Dimension getMaximumSize() {
      return getPreferredSize();
   }

   public Dimension getMinimumSize() {
      return getPreferredSize();
   }
}