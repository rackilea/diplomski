import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestGridBagLayout {

    protected void initUI() {
        JFrame frame = new JFrame();
        JPanel controlPanel = (JPanel) frame.getContentPane();
        controlPanel.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        JPanel fromDatePanel = new JPanel(new FlowLayout());
        JPanel untilDatePanel = new JPanel(new FlowLayout());

        fromDatePanel.add(new JLabel("From - "));
        fromDatePanel.add(new JButton("..."));
        untilDatePanel.add(new JLabel("Until - "));
        untilDatePanel.add(new JButton("..."));

        controlPanel.add(fromDatePanel, gbc);
        controlPanel.add(untilDatePanel, gbc);
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