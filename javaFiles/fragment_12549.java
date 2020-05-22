import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class BrowserFoo {

   private static void createAndShowGui() {
      JPanel topPanel = new JPanel(new BorderLayout(2, 2));
      topPanel.add(new JButton("Back"), BorderLayout.WEST);
      topPanel.add(new JTextField(20), BorderLayout.CENTER);

      JPanel mainPanel = new JPanel(new BorderLayout());
      mainPanel.add(topPanel, BorderLayout.NORTH);
      mainPanel.add(Box.createRigidArea(new Dimension(400, 400)));

      JFrame frame = new JFrame("BrowserFoo");
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