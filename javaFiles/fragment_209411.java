import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setTitle("frame");
        final JButton button = new JButton(new AbstractAction("Action text") {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println("Hello");
            }
        });
        button.setText("Button text which is a lot longer");
        button.setPreferredSize(new Dimension(100, 30));
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
    }
}