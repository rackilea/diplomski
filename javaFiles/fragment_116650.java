import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class ChangeStepSize extends JPanel {
   private static final String DOUBLE_STEP = "double step";
   public static final int SMALL_STEP_SIZE = 1;
   public static final int BIG_STEP_SIZE = 10;

   // bind to the "d" key, but you could use any key you'd like
   private static final int SPECIAL_KEY = KeyEvent.VK_D;
   private SpinnerNumberModel numberModel = new SpinnerNumberModel(50, 0, 100, 1);
   private JSpinner spinner = new JSpinner(numberModel);

   public ChangeStepSize() {
      add(spinner);

      // set up key bindings. First get InputMap and ActionMap
      InputMap inputMap = spinner.getInputMap(JComponent.WHEN_FOCUSED);
      ActionMap actionMap = spinner.getActionMap();

      // next set bindings for when key is pressed
      boolean onKeyRelease = false;
      KeyStroke keyStroke = KeyStroke.getKeyStroke(SPECIAL_KEY, 0, onKeyRelease);
      inputMap.put(keyStroke, DOUBLE_STEP + onKeyRelease);
      actionMap.put(DOUBLE_STEP + onKeyRelease, new DoubleStepAction(onKeyRelease));

      // next set bindings for when key is released
      onKeyRelease = true;
      keyStroke = KeyStroke.getKeyStroke(SPECIAL_KEY, 0, onKeyRelease);
      inputMap.put(keyStroke, DOUBLE_STEP + onKeyRelease);
      actionMap.put(DOUBLE_STEP + onKeyRelease, new DoubleStepAction(onKeyRelease));
   }

   // our Action is passed in a parameter to indicate which state it
   // gets activated in: key press or key release
   private class DoubleStepAction extends AbstractAction {
      private boolean onKeyRelease;

      public DoubleStepAction(boolean onKeyRelease) {
         this.onKeyRelease = onKeyRelease;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         if (onKeyRelease) {
            numberModel.setStepSize(SMALL_STEP_SIZE);
         } else {
            numberModel.setStepSize(BIG_STEP_SIZE);
         }
      }
   }

   private static void createAndShowGui() {
      ChangeStepSize mainPanel = new ChangeStepSize();

      JFrame frame = new JFrame("ChangeStepSize");
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