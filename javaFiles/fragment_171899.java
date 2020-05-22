import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestJPanels {

    protected void initUI() {
        final JFrame frame = new JFrame(TestJPanels.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        for (int i = 0; i < 5; i++) {
            JLabel label = new JLabel("Label-" + i);
            label.setBorder(BorderFactory.createLineBorder(Color.GREEN));
            JPanel insidePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            insidePanel.add(label);
            insidePanel.setBorder(BorderFactory.createLineBorder(Color.RED));
            panel.add(insidePanel);
        }
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestJPanels().initUI();
            }
        });
    }
}