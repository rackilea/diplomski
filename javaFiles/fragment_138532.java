import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextField extends JTextField {


public TextField(String text) {
    super(text);

    addFocusListener(new FocusAdapter() {

        @Override
        public void focusGained(FocusEvent fe) {
             selectAll();
        }
    });
}

public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {

        public void run() {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextField tf = new JTextField("normal field");
            f.add(tf, BorderLayout.CENTER);

            TextField ftf =
                    new TextField("funny text field");
            f.add(ftf, BorderLayout.SOUTH);

            f.pack();
            f.setVisible(true);
        }
    });
}
}