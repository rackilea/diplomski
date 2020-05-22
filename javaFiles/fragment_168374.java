import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ShyLabel {

    private JFrame frame;
    private JLabel label;
    private Timer timer;
    private boolean isVisible;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShyLabel().createAndShowGui();
            }
        });
    }

    public void createAndShowGui() {
        String labelText = "I'm a shy label that hides every 2 seconds";

        isVisible = true;
        frame = new JFrame(getClass().getSimpleName());
        label = new JLabel(labelText);
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(isVisible ? "" : labelText);
                isVisible = !isVisible;
            }
        });

        timer.setInitialDelay(2000);
        timer.start();

        frame.add(label);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}