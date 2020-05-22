import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VerifierTest extends JFrame {

    private static final long serialVersionUID = 1L;

    public VerifierTest() {
        final JTextField tf = new JTextField("TextField1");

        getContentPane().add(tf, BorderLayout.NORTH);
        tf.setInputVerifier(new PassVerifier());

        final JButton b = new JButton("Button");
        b.setVerifyInputWhenFocusTarget(true);
        getContentPane().add(b, BorderLayout.EAST);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tf.getInputVerifier().verify(tf)) {
                    JOptionPane.showMessageDialog(tf.getParent(), "illegal value: " + tf.getText(), "Illegal Value",
                            JOptionPane.ERROR_MESSAGE);
                }
                if (b.hasFocus()) {
                    System.out.println("Button clicked");
                }
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Frame frame = new VerifierTest();
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    class PassVerifier extends InputVerifier {

        @Override
        public boolean verify(JComponent input) {
            final JTextField tf = (JTextField) input;
            String pass = tf.getText();
            return pass.equals("Manish");
        }
    }
}