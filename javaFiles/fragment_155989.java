import java.awt.event.ActionEvent;
import javax.swing.*;

public class AlunoExample {
   private static void createAndShowGui() {
      MainPanel mainPanel = new MainPanel();

      JFrame frame = new JFrame("AlunoExample");
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

class MainPanel extends JPanel {
   private JTextField field = new JTextField(20);
   private DialogPanel dialogPanel = new DialogPanel();

   public MainPanel() {
      field.setEditable(false);
      field.setFocusable(false);

      add(new JLabel("Aluno:"));
      add(field);
      add(new JButton(new AbstractAction("Create Aluno") {

         @Override
         public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(MainPanel.this,
                  dialogPanel, "Dialog", JOptionPane.OK_CANCEL_OPTION,
                  JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
               String name = dialogPanel.getNameText();
               int value = dialogPanel.getValue();
               Aluno aluno = new Aluno(name, value);
               field.setText(aluno.toString());
            }

         }
      }));
   }
}

class DialogPanel extends JPanel {
   private JTextField nameField = new JTextField(5);
   private JSpinner spinner = new JSpinner(
         new SpinnerNumberModel(50, 0, 100, 1));

   public DialogPanel() {
      add(new JLabel("Name:"));
      add(nameField);
      add(new JLabel("Value:"));
      add(spinner);
   }

   public String getNameText() {
      return nameField.getText();
   }

   public int getValue() {
      return ((Integer) spinner.getValue()).intValue();
   }
}

class Aluno {
   private String name;
   private int value;

   public Aluno(String name, int value) {
      this.name = name;
      this.value = value;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getValue() {
      return value;
   }

   public void setValue(int value) {
      this.value = value;
   }

   @Override
   public String toString() {
      return "Aluno [name=" + name + ", value=" + value + "]";
   }

}