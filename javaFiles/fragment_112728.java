import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestGridBagLayout {

    protected void initUI() {
        JFrame frame = new JFrame("test");
        final JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        JButton playButton = new JButton("Play");
        JButton optionsButton = new JButton("Options");
        JButton manualButton = new JButton("Manual");
        JButton exitButton = new JButton("Exit");
        JButton creditsButton = new JButton("Credits");
        JButton legalNoticeButton = new JButton("Legal");
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        centerPanel.add(playButton, c);
        centerPanel.add(optionsButton, c);
        centerPanel.add(manualButton, c);
        centerPanel.add(exitButton, c);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(creditsButton, BorderLayout.WEST);
        // Filler component that avoids having the bottom panel too small
        bottomPanel.add(new JComponent() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(centerPanel.getPreferredSize().width, 0);
            }
        });
        bottomPanel.add(legalNoticeButton, BorderLayout.EAST);
        frame.add(centerPanel);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setMinimumSize(frame.getPreferredSize());
        frame.setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestGridBagLayout().initUI();
            }
        });
    }
}