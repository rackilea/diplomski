import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;
import javax.swing.*;

public class SwingTest {
   private JPanel mainPanel = new JPanel();
   private JTextField numberField = new JTextField("5x", 5);

   @SuppressWarnings("serial")
   public SwingTest() {
      MyFailAction myFailAction = new MyFailAction();
      numberField.setAction(myFailAction);
      mainPanel.add(new JLabel("String to parse into an int:"));
      mainPanel.add(numberField);
      mainPanel.add(new JButton(myFailAction));
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }

   private class MyFailAction extends AbstractAction {

      public MyFailAction() {
         super("Push to Fail");
         putValue(MNEMONIC_KEY, KeyEvent.VK_P);
      }

      @Override
      public void actionPerformed(ActionEvent arg0) {
         String text = numberField.getText();
         final MySwingWorker mySw = new MySwingWorker(text);
         mySw.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
               if (evt.getPropertyName().equals("state")) {
                  if (evt.getNewValue().equals(SwingWorker.StateValue.DONE)) {
                     try {
                        // **** here I call get() on my SwingWorker ****
                        int value = mySw.get();
                        JOptionPane.showMessageDialog(mainPanel, "value is "
                              + value);
                     } catch (InterruptedException | ExecutionException e) {
                        if (e.getCause() instanceof NumberFormatException) {
                           String message = "A NumberFormatException has occurred when trying to parse \""
                                 + numberField.getText() + "\" to an int\n" +
                                 "Reseting field to \"0\"";
                           JOptionPane.showMessageDialog(mainPanel, message,
                                 "NumberFormatException",
                                 JOptionPane.ERROR_MESSAGE);
                        }

                        StringBuilder sb = new StringBuilder();
                        sb.append(e.getMessage() + "\n");
                        for (StackTraceElement ele : e.getStackTrace()) {
                           sb.append(ele.toString() + "\n");
                        }
                        sb.append("\n");
                        sb.append("*****   Cause:   *****\n");
                        sb.append(e.getCause().getLocalizedMessage());
                        for (StackTraceElement ele : e.getCause()
                              .getStackTrace()) {
                           sb.append(ele.toString() + "\n");
                        }
                        JTextArea textArea = new JTextArea(sb.toString());
                        JScrollPane message = new JScrollPane(textArea);
                        JOptionPane.showMessageDialog(mainPanel, message,
                              "Error Specifics", JOptionPane.ERROR_MESSAGE);
                        numberField.setText("0");
                     }
                  }
               }
            }
         });
         mySw.execute();
      }
   }

   private class MySwingWorker extends SwingWorker<Integer, Void> {
      private static final long SLEEP_DELAY = 1000;
      private String text;

      public MySwingWorker(String text) {
         this.text = text;
      }

      @Override
      protected Integer doInBackground() throws Exception {
         Thread.sleep(SLEEP_DELAY);
         int value = Integer.parseInt(text);
         return value;
      }
   }

   private static void createAndShowGui() {
      SwingTest swingTest = new SwingTest();

      JFrame frame = new JFrame("SwingTest");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(swingTest.getMainPanel());
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