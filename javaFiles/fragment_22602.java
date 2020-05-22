import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

/** @see http://stackoverflow.com/questions/6566612 */
public class TitledBorderTest {

     public static void main(String[] args) {
          EventQueue.invokeLater(new Runnable() {
              public void run() {
                  new TitledBorderTest().create();
              }
          });
     }

     private void create() {

         String s = "This is a TitledBorder update test.";
         final JLabel label = new JLabel(s);
         final TitledBorder tb =
             BorderFactory.createTitledBorder(new Date().toString());
         label.setBorder(tb);
         JFrame f = new JFrame("Titled Border Test");
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.add(label);
         f.add(new JButton(new AbstractAction("Update") {

            public void actionPerformed(ActionEvent e) {
                tb.setTitle(new Date().toString());
                label.repaint();
            }
        }), BorderLayout.SOUTH);
         f.pack();
         f.setLocationRelativeTo(null);
         f.setVisible(true);
         System.out.println(tb.getMinimumSize(f));
     }
}