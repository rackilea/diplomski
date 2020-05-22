import java.awt.event.*;
import javax.swing.*;

public class TestPanel extends JPanel implements WindowListener {
    private JLabel label = new JLabel("No window events yet");
    private int numEvents = 0;

    public TestPanel() {this.add(label);}

    private void update() {
        label.setText(String.format("%d events",numEvents));
    }

    public void windowOpened(WindowEvent e) {
        numEvents++;
        update();
    }

    // ... similar implementations of the other WindowListener methods ...
}