import java.awt.GridBagLayout;
import java.awt.event.*;
import javax.swing.*;


public class test {
        public static void main(String[] args) {

            JTextField fecha = new JTextField(10);

            /* add a new action named "foo" to the panel's action map */
            fecha.getActionMap().put("foo", new AbstractAction() {

                private static final long serialVersionUID = 1L;
                    public void actionPerformed(ActionEvent e) {
                        fecha.setText(java.time.LocalDate.now().toString());

                    }
                });


            InputMap inputMap = fecha.getInputMap();
            KeyStroke controlA =  KeyStroke.getKeyStroke("control A");
            inputMap.put(KeyStroke.getKeyStroke(Character.valueOf('a'), 0), "foo");
            inputMap.put(controlA, "foo");

            /* display the panel in a frame */
            JFrame frame = new JFrame();
            frame.getContentPane().add(fecha);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridBagLayout());
            frame.setSize(400, 400);
            frame.setVisible(true);

        }
}