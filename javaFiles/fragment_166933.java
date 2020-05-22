import java.awt.Dimension;
import javax.swing.*;

public class MenuEg {

   private static void createAndShowGui() {
      JMenuBar menuBar = new JMenuBar();
      menuBar.add(new JMenu("File"));
      menuBar.add(new JMenu("Edit"));
      menuBar.add(new JMenu("View"));
      menuBar.add(new JMenu("Window"));

      menuBar.add(Box.createHorizontalGlue());
      menuBar.add(new JMenu("Help"));

      JFrame frame = new JFrame("MenuEg");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setJMenuBar(menuBar);
      frame.getContentPane().add(Box.createRigidArea(new Dimension(600, 400)));
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