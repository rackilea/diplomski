import java.awt.EventQueue;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/** @see http://stackoverflow.com/questions/6911309 */
public class PaymentPanel extends Box {

    public PaymentPanel() {
        super(BoxLayout.Y_AXIS);
        this.add(new JLabel("Payment Setup"));
        this.add(Box.createVerticalStrut(10));
        this.add(new JRadioButton("New payment Method", true));
        this.add(Box.createVerticalStrut(10));
        this.add(new JLabel("Invoice"));
    }

    private void display() {
        JFrame f = new JFrame("PaymentPanel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new PaymentPanel().display();
            }
        });
    }
}