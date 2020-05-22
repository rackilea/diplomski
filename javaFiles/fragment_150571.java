import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class SearchPanel2 {
    public static void main(final String[] args) {
        new SearchPanel2().launchGui();
    }

    private void launchGui() {
        final JFrame frame = new JFrame("Stack Overflow: box layout & scroll panes");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        final Dimension maximumSize = new Dimension(Integer.MAX_VALUE, 80);
        addLabel(panel, "one", maximumSize);
        addLabel(panel, "zwei", maximumSize);
        addLabel(panel, "trois", maximumSize);
        addLabel(panel, "vier", maximumSize);
        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    private void addLabel(JPanel panel, String word, Dimension maximumSize) {
        String text = ".......... " + word;
        for (int blahIndex = 0; blahIndex < 28; blahIndex++)
            text += " ..........";
        final JScrollPane scrollPane = new JScrollPane(new JLabel(text));
        scrollPane.setMaximumSize(maximumSize);
        panel.add(scrollPane);
    }
}