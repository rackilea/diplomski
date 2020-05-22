import java.awt.Color;
import java.awt.Dimension;
import java.awt.Dialog.ModalityType;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class DimView {
   protected static final Color GP_COLOR = new Color(0, 0, 0, 30);

   private static void createAndShowGui() {
      final JFrame frame = new JFrame("DimView");
      final JPanel glassPanel = new JPanel() {
         protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(GP_COLOR);
            g.fillRect(0, 0, getWidth(), getHeight());
         };
      };
      glassPanel.setOpaque(false);
      frame.setGlassPane(glassPanel);
      JPanel mainPanel = new JPanel();
      mainPanel.setPreferredSize(new Dimension(400, 400));
      mainPanel.setBackground(Color.pink);
      mainPanel.add(new JButton(new AbstractAction("Push Me") {

         @Override
         public void actionPerformed(ActionEvent evt) {
            glassPanel.setVisible(true);

            JDialog dialog = new JDialog(frame, "Dialog",
                  ModalityType.APPLICATION_MODAL);
            dialog.add(Box.createRigidArea(new Dimension(200, 200)));
            dialog.pack();
            dialog.setLocationRelativeTo(frame);
            dialog.setVisible(true);

            glassPanel.setVisible(false);
         }
      }));

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
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