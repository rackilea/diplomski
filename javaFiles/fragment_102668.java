import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.pushingpixels.trident.Timeline;
import org.pushingpixels.trident.Timeline.RepeatBehavior;

public class TestPanel {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Some text"));

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        final Timeline timeline = new Timeline(panel);
        timeline.addPropertyToInterpolate("background", panel.getBackground(),
                Color.red);
        timeline.setDuration(1000);

        timeline.playLoop(5, RepeatBehavior.REVERSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}