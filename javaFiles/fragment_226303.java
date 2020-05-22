import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MyMain extends JPanel {
   private JTextField actorInput = new JTextField(10);
   private JTextField genreInput = new JTextField(10);

   public MyMain() {
      // JPanels use FlowLayout by default

      add(actorInput);
      add(genreInput);
      add(new JButton(new SubmitAction("Submit")));
      add(new JButton(new ExitAction("Exit", KeyEvent.VK_X)));
   }

   private class SubmitAction extends AbstractAction {
      public SubmitAction(String name) {
         super(name);
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         String actor = actorInput.getText();
         String genre = genreInput.getText();

         // call database code here in a background thread
         // show a dialog with information

         String textToDisplay = "Text to display\n";
         textToDisplay += "Actor: " + actor + "\n";
         textToDisplay += "Genre: " + genre + "\n";

         InfoDialogPanel dlgPanel = new InfoDialogPanel();
         dlgPanel.textAreaSetText(textToDisplay);

         Window window = SwingUtilities.getWindowAncestor(MyMain.this);
         JDialog modalDialog = new JDialog(window, "Dialog", ModalityType.APPLICATION_MODAL);
         modalDialog.getContentPane().add(dlgPanel);
         modalDialog.pack();
         modalDialog.setLocationByPlatform(true);
         modalDialog.setVisible(true);
      }
   }

   private static void createAndShowGui() {
      MyMain mainPanel = new MyMain();

      JFrame frame = new JFrame("MyMain");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

class InfoDialogPanel extends JPanel {
   private JTextArea textArea = new JTextArea(10, 20);
   private JScrollPane scrollPane = new JScrollPane(textArea);

   public InfoDialogPanel() {
      JPanel btnPanel = new JPanel();
      btnPanel.add(new JButton(new ExitAction("Exit", KeyEvent.VK_X)));      

      setLayout(new BorderLayout());
      add(scrollPane, BorderLayout.CENTER);
      add(btnPanel, BorderLayout.PAGE_END);
   }

   public void textAreaSetText(String text) {
      textArea.setText(text);
   }

   public void textAreaAppend(String text) {
      textArea.append(text);
   }
}

class ExitAction extends AbstractAction {

   public ExitAction(String name, int mnemonic) {
      super(name);
      putValue(MNEMONIC_KEY, mnemonic);
   }

   @Override
   public void actionPerformed(ActionEvent evt) {
      Component component = (Component) evt.getSource();
      Window win = SwingUtilities.getWindowAncestor(component);
      win.dispose();
   }
}