import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class JOptionPaneShowMessageDialog implements ActionListener {
   JFrame myFrame = null;
   public static void main(String[] a) {
      (new JOptionPaneShowMessageDialog()).test();
   }
   private void test() {
      myFrame = new JFrame("showMessageDialog Test");
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.setBounds(50,50,250,150);
      myFrame.setContentPane(new JDesktopPane());
      JMenuBar myMenuBar = new JMenuBar();
      JMenu myMenu = getDialogMenu();
      myMenuBar.add(myMenu);
      myFrame.setJMenuBar(myMenuBar);
      myFrame.setVisible(true);
   }
   private JMenu getDialogMenu() {
      JMenu myMenu = new JMenu("Dialogs");
      JMenuItem myItem = new JMenuItem("Information");
      myItem.addActionListener(this);
      myMenu.add(myItem);
      myItem = new JMenuItem("Warning");
      myItem.addActionListener(this);
      myMenu.add(myItem);
      myItem = new JMenuItem("Error");
      myItem.addActionListener(this);
      myMenu.add(myItem);
      myItem = new JMenuItem("Plain");
      myItem.addActionListener(this);
      myMenu.add(myItem);
      return myMenu;
   }
   public void actionPerformed(ActionEvent e) {
      String menuText = ((JMenuItem) e.getSource()).getText();
      int messageType = JOptionPane.INFORMATION_MESSAGE;
      if (menuText.equals("Information")) {
         messageType = JOptionPane.INFORMATION_MESSAGE;
      } else if (menuText.equals("Warning")) {
         messageType = JOptionPane.WARNING_MESSAGE;
      } else if (menuText.equals("Error")) {
         messageType = JOptionPane.ERROR_MESSAGE;
      } else if (menuText.equals("Plain")) {
         messageType = JOptionPane.PLAIN_MESSAGE;
      }

      System.out.println("Before displaying the dialog: "+menuText);
      JOptionPane.showMessageDialog(myFrame, 
         "This is message dialog box of type: "+menuText,
         menuText+" Message", messageType);
      System.out.println("After displaying the dialog: "+menuText);
   }
}