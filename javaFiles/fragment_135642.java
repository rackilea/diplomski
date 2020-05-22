import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Window;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyTest {
   private static void createAndShowGui() {
      MainGuiPanel mainGuiPanel = new MainGuiPanel();

      final JFrame frame = new JFrame("MyTest");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainGuiPanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      // frame.setVisible(true);

      DialogPanel dialogPanel = new DialogPanel();
      JDialog dialog = new JDialog(frame, "Select User", ModalityType.APPLICATION_MODAL);
      dialog.add(dialogPanel);
      dialog.pack();
      dialog.setLocationRelativeTo(null);
      // show modal dialog
      dialog.setVisible(true);

      // here dialog is no longer visible

      // extract datat from dialog's dialogPanel
      String selectedUser = dialogPanel.getSelectedName();
      // put into the main GUI
      mainGuiPanel.setSelectedUser(selectedUser);
      // now show the main GUI's JFrame
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

class MainGuiPanel extends JPanel {
   private static final long serialVersionUID = 1L;
   private JButton doItButton = new JButton(new DoItAction("Do It!", KeyEvent.VK_D));
   private String selectedUser;

   public MainGuiPanel() {
      add(doItButton);
   }

   public void setSelectedUser(String selectedUser) {
      this.selectedUser = selectedUser;
   }

   private class DoItAction extends AbstractAction {
      public DoItAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         System.out.println("Selected User: " + selectedUser);
      }
   }
}

class DialogPanel extends JPanel {
   private static final long serialVersionUID = 1L;
   public static final String[] USER_NAMES = { "Jannie", "Heloise", "Juan", "Chane" };
   private JList<String> userList = new JList<>(USER_NAMES);
   private String selectedName;

   public DialogPanel() {
      userList.addListSelectionListener(new UserListListener());
      add(new JScrollPane(userList));
   }

   public String getSelectedName() {
      return selectedName;
   }

   private class UserListListener implements ListSelectionListener {

      @Override
      public void valueChanged(ListSelectionEvent e) {
         if (!e.getValueIsAdjusting()) {
            selectedName = userList.getSelectedValue();
            if (selectedName != null) {
               Window win = SwingUtilities.getWindowAncestor(DialogPanel.this);
               win.dispose();
            }
         }
      }
   }
}