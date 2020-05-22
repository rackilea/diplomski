import java.awt.Component;
import java.awt.Container;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

public class Foo extends JPanel {
   private static final String[] DIALOG_BUTTON_TITLES = new String[] { "Aceptar", "Cancelar" };
   private JCheckBox checkBox = new JCheckBox("Buttons Enabled", true);
   private Set<AbstractButton> exemptButtons = new HashSet<AbstractButton>();

   public Foo() {
      JButton exemptBtn = new JButton("Exempt Button");
      JButton nonExemptBtn = new JButton("Non-Exempt Button");

      add(checkBox);
      add(exemptBtn);
      add(nonExemptBtn);
      exemptButtons.add(checkBox);
      exemptButtons.add(exemptBtn);

      checkBox.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent evt) {
            allBtnsSetEnabled(checkBox.isSelected());
         }
      });

   }

   private void allBtnsSetEnabled(boolean enabled) {
      JRootPane rootPane = SwingUtilities.getRootPane(checkBox);
      if (rootPane != null) {
         Container container = rootPane.getContentPane();
         recursiveBtnEnable(enabled, container);
      }
   }

   private void recursiveBtnEnable(boolean enabled, Container container) {
      Component[] components = container.getComponents();
      for (Component component : components) {
         if (component instanceof AbstractButton && !exemptButtons.contains(component)) {
            ((AbstractButton) component).setEnabled(enabled);
         } else if (component instanceof Container) {
            recursiveBtnEnable(enabled, (Container) component);
         }
      }
   }

   public int showDialog() {
      return JOptionPane.showOptionDialog(null, this, "Sirena",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
            DIALOG_BUTTON_TITLES, "Aceptar");
   }


   private static void createAndShowGui() {
      Foo foo = new Foo();
      int result = foo.showDialog();
      System.out.println(DIALOG_BUTTON_TITLES[result]);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}