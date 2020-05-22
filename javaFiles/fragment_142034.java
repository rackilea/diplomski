import java.awt.Dialog.ModalityType;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MyServerMain extends JPanel {
   private JTextField serverIp = new JTextField(8);
   private JTextField serverPort = new JTextField(8);
   private ServerConnect serverConnect = new ServerConnect();
   private JDialog serverConnectDialog = null;

   public MyServerMain() {
      serverIp.setFocusable(false);
      serverPort.setFocusable(false);

      add(new JLabel("Server IP:"));
      add(serverIp);
      add(new JLabel("Server Port:"));
      add(serverPort);
      add(new JButton(new SetUpServerAction("Set Up Server", KeyEvent.VK_S)));
   }

   private class SetUpServerAction extends AbstractAction {
      public SetUpServerAction(String name, int keyCode) {
         super(name);
         putValue(MNEMONIC_KEY, keyCode);
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         if (serverConnectDialog == null) {
            Window owner = SwingUtilities.getWindowAncestor(MyServerMain.this);
            serverConnectDialog = new JDialog(owner, "Server Set Up",
                  ModalityType.APPLICATION_MODAL);

            serverConnectDialog.getContentPane().add(serverConnect);
            serverConnectDialog.pack();
            serverConnectDialog.setLocationRelativeTo(owner);
         }
         serverConnectDialog.setVisible(true);

         // when here, the dialog is no longer visible
         // so extract information from the serverConnect object
         serverIp.setText(serverConnect.getServerIp());
         serverPort.setText(serverConnect.getServerPort());
      }
   }

   private static void createAndShowGui() {
      MyServerMain mainPanel = new MyServerMain();

      JFrame frame = new JFrame("My Server Main");
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