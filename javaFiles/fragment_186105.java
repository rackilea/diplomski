import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public final class DialogBeforeFrame extends JFrame {
   /** Dialog that prompts for a single string as input. */
   private static class SetupDialog extends JDialog {
      final JTextField input;
      public SetupDialog() {
         super();
         setModal(true);
         setLayout(new BorderLayout());
         input = new JTextField("Some text");
         add(input, BorderLayout.CENTER);
         add(new JButton(new AbstractAction("Ok") {
               public void actionPerformed(ActionEvent e) {
                  setVisible(false);
               }
            }), BorderLayout.SOUTH);
      }
      public String getInput() { return input.getText().trim(); }
   }

   /** Constructor that takes the text to display as argument. */
   public DialogBeforeFrame(String text) {
      super();
      add(new JLabel(text));
   }
   /** Constructor that shows a dialog which prompts for the text to be displayed. */
   public DialogBeforeFrame() {
      super();

      final SetupDialog dialog = new SetupDialog();
      dialog.pack();
      dialog.setVisible(true);

      add(new JLabel(dialog.getInput()));
   }


   public static void main(String[] args) {
      JFrame frame = null;

      // Two variants of constructing the frame:
      // 1. We first show the dialog, extract the configuration from the dialog
      //    and then construct the frame with these arguments.
      // 2. We have the frame's constructor show a dialog for configuration.
      if ( false ) {
         final SetupDialog dialog = new SetupDialog();
         dialog.pack();
         dialog.setVisible(true);

         frame = new DialogBeforeFrame(dialog.getInput());
      }
      else {
         frame = new DialogBeforeFrame();
      }

      frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               System.exit(0);
            }
         });
      frame.pack();
      frame.setVisible(true);
   }
}