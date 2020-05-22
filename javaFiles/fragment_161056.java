import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogClosing {
   private static void createAndShowGui() {
      JFrame frame = new JFrame("DialogClosing");

      JPanel mainPanel = new JPanel();
      mainPanel.add(new JButton(new MyAction(frame, JDialog.DISPOSE_ON_CLOSE, "DISPOSE_ON_CLOSE")));
      mainPanel.add(new JButton(new MyAction(frame, JDialog.HIDE_ON_CLOSE, "HIDE_ON_CLOSE")));
      mainPanel.add(new JButton(new MyAction(frame, JDialog.DO_NOTHING_ON_CLOSE, "DO_NOTHING_ON_CLOSE")));

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

class MyAction extends AbstractAction {
   private JDialog dialog;
   private String title;

   public MyAction(JFrame frame, int defaultCloseOp, final String title) {
      super(title);
      dialog = new JDialog(frame, title, false);
      dialog.setDefaultCloseOperation(defaultCloseOp);
      dialog.setPreferredSize(new Dimension(300, 200));
      dialog.pack();
      dialog.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosed(WindowEvent e) {
            System.out.println(title + " window closed");
         }
         @Override
         public void windowClosing(WindowEvent e) {
            System.out.println(title + " window closing");
         }
      });

      this.title = title;
   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      dialog.setVisible(true);
   }
}