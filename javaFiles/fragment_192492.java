import java.awt.event.ActionEvent;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyMain extends JPanel {
   public MyMain() {
      add(new JButton(new ConnectionAction("Connect", this)));
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("My Main");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new MyMain());
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

@SuppressWarnings("serial")
class ConnectionAction extends AbstractAction {
   private MyMain myMain;
   private ConnectionPanel cPanel = null;
   private JDialog dialog = null;

   public ConnectionAction(String title, MyMain myMain) {
      super(title);
      this.myMain = myMain;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (dialog == null) {
         dialog = new JDialog(SwingUtilities.getWindowAncestor(myMain));
         dialog.setTitle("Connect");
         dialog.setModal(true);
         cPanel = new ConnectionPanel(new ConnectionPanelControl() {

            @Override
            public void connectButtonAction() {
               final String connectStr = cPanel.getFieldText();
               new MySwingWorker(connectStr).execute();
            }
         });
         dialog.getContentPane().add(cPanel);
         dialog.pack();
         dialog.setLocationRelativeTo(null);
      }
      dialog.setVisible(true);
   }

   private class MySwingWorker extends SwingWorker<Boolean, Void> {
      private String connectStr = "";

      public MySwingWorker(String connectStr) {
         this.connectStr = connectStr;
      }

      @Override
      protected Boolean doInBackground() throws Exception {
         // TODO: make connection and then return a result
         // right now making true if any text in the field
         if (!connectStr.isEmpty()) {
            return true;
         }
         return false;
      }

      @Override
      protected void done() {
         try {
            boolean result = get();
            if (result) {
               System.out.println("connection successful");
               dialog.dispose();
            } else {
               System.out.println("connection not successful");
            }
         } catch (InterruptedException e) {
            e.printStackTrace();
         } catch (ExecutionException e) {
            e.printStackTrace();
         }
      }
   }
}