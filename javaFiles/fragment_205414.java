import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestGridBagLayout {

    protected void initUI() {
        JFrame frame = new JFrame();
        JPanel controlPanel = (JPanel) frame.getContentPane();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel fromDatePanel = new JPanel(new FlowLayout()) {
            @Override
            public Dimension getMaximumSize() {
                return getPreferredSize();
            }
        };
        JPanel untilDatePanel = new JPanel(new FlowLayout()) {
            @Override
            public Dimension getMaximumSize() {
                return super.getMaximumSize();
            }
        };

        fromDatePanel.add(new JLabel("From - "));
        fromDatePanel.add(new JButton("..."));
        untilDatePanel.add(new JLabel("Until - "));
        untilDatePanel.add(new JButton("..."));

        controlPanel.add(fromDatePanel);
        controlPanel.add(untilDatePanel);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestGridBagLayout testMultiplePanels = new TestGridBagLayout();
                testMultiplePanels.initUI();

            }
        });
    }

}