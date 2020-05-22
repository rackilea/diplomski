import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEnteredPressed extends JPanel {
   private static final int SIDE = 500;

   public MouseEnteredPressed() {
      setLayout(new GridBagLayout());
      JLabel label = new JLabel("Hovercraft Rules The World!");
      label.setFont(label.getFont().deriveFont(Font.BOLD, 24));
      label.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
      add(label);

      label.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent mEvt) {
            System.out.println("mouse entered");

            if (mEvt.getModifiers() == MouseEvent.BUTTON1_MASK) {
               System.out.println("Mouse dragging as entered");
            }
         }
      });

   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(SIDE, SIDE);
   }

   private static void createAndShowGui() {
      MouseEnteredPressed mainPanel = new MouseEnteredPressed();

      JFrame frame = new JFrame("MouseEnteredPressed");
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