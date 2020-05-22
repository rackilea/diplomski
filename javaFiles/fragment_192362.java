import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MinimalExProgram3 extends JPanel {
   private static void createAndShowGui() {
      MainPanel mainPanel = new MainPanel();

      JFrame frame = new JFrame("MinimalExProgram3");
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

@SuppressWarnings("serial")
class MainPanel extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private JTextField field = new JTextField(8);
   private ComboPanel comboPanel = new ComboPanel();
   JDialog dialog = null;

   public MainPanel() {
      field.setFocusable(false);

      add(field);
      add(new JButton(new ShowComboAction("Show Combo")));
   }

   @Override // make it bigger
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class ShowComboAction extends AbstractAction {
      public ShowComboAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         Window mainWin = SwingUtilities.getWindowAncestor(MainPanel.this);
         if (dialog == null) {
            dialog = new JDialog(mainWin, "Dialog", ModalityType.APPLICATION_MODAL);
            dialog.add(comboPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
         }

         dialog.setVisible(true);

         // code called here after dialog no longer visible
         String text = comboPanel.getText();
         field.setText(text);
      }
   }
}

@SuppressWarnings("serial")
class ComboPanel extends JPanel {
   private static final String[] DESCRIPTION = { "One", "Two", "Three" };
   private int ind;
   private JComboBox<String> combo = new JComboBox<>(DESCRIPTION);
   private String text;
   private SelectionAction selectionAction = new SelectionAction("Select");
   private JButton selectionButton = new JButton(selectionAction);

   public ComboPanel() {
      add(combo);
      add(selectionButton);

      combo.setAction(selectionAction);
   }

   public int getInd() {
      return ind;
   }

   public String getText() {
      return text;
   }

   private class SelectionAction extends AbstractAction {
      public SelectionAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         ind = combo.getSelectedIndex();
         if (ind >= 0) {
            text = combo.getSelectedItem().toString();
         }
         Window win = SwingUtilities.getWindowAncestor(ComboPanel.this);
         win.dispose();
      }
   }
}