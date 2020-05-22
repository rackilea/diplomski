import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Foo2 extends JPanel {
   private static final String[] DIALOG_BUTTON_TITLES = new String[] {
         "Aceptar", "Cancelar" };
   private static final int FIELD_COUNT = 10;
   private Set<AbstractButton> exemptButtons = new HashSet<AbstractButton>();
   private JTextField[] fields = new JTextField[FIELD_COUNT];

   public Foo2() {
      setLayout(new GridLayout(0, 5, 5, 5));
      DocumentListener myDocListener = new MyDocumentListener();
      for (int i = 0; i < fields.length; i++) {
         fields[i] = new JTextField(10);
         add(fields[i]);
         fields[i].getDocument().addDocumentListener(myDocListener);
      }

      // cheating here

      int timerDelay = 200;
      Timer timer = new Timer(timerDelay , new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            checkDocsForText();            
         }
      });
      timer.setRepeats(false);
      timer.setInitialDelay(timerDelay);
      timer.start();

   }

   private void checkDocsForText() {
      for (JTextField field : fields) {
         if (field.getText().trim().isEmpty()) {
            allBtnsSetEnabled(false);
            return;
         }
      }
      allBtnsSetEnabled(true);
   }

   private void allBtnsSetEnabled(boolean enabled) {
      JRootPane rootPane = SwingUtilities.getRootPane(this);
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

   private class MyDocumentListener implements DocumentListener {

      public void removeUpdate(DocumentEvent arg0) {
         checkDocsForText();
      }

      public void insertUpdate(DocumentEvent arg0) {
         checkDocsForText();
      }

      public void changedUpdate(DocumentEvent arg0) {
         checkDocsForText();
      }
   }


   private static void createAndShowGui() {
      Foo2 foo = new Foo2();
      int result = foo.showDialog();
      if (result >= 0) {
         System.out.println(DIALOG_BUTTON_TITLES[result]);
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }

}