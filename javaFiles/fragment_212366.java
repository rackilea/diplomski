import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class ButtonTest {
   public static void main(String[] args) {
      ButtonFrame frame = new ButtonFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

class ButtonFrame extends JFrame {

   private JTextField loanAmt; // !! Make field private

   @SuppressWarnings("LeakingThisInConstructor")
   public ButtonFrame() {

      setTitle("SunStream Loan Calculator v2.0");
      setSize(900, 900);
      ButtonPanel panel = new ButtonPanel();
      panel.add(new JLabel("Enter your loan amount:"));
      loanAmt = new JTextField(40);
      panel.add(loanAmt);

      add(panel, BorderLayout.CENTER);
   }

   // !! create a public method to get JTextField's text
   // !! without exposing the JTextField itself.
   public String getLoanAmtText() {
      return loanAmt.getText();
   }

   class ButtonPanel extends JPanel implements ActionListener {
      private Component frame;

      public ButtonPanel() {

         final JButton b2 = new JButton("Calculate");
         add(b2, BorderLayout.SOUTH);
         b2.setActionCommand("calculate");
         b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // !! ButtonFrame bf = new ButtonFrame();
               if ("calculate".equals(e.getActionCommand())) {

                  //!! call public method on ButtonFrame object
                  JOptionPane.showMessageDialog(frame,
                        ButtonFrame.this.getLoanAmtText());
               }
            }

         });

      }

      @Override
      public void actionPerformed(ActionEvent ae) {
         throw new UnsupportedOperationException("Not supported yet.");
      }

   }
}