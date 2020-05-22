import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mega extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Mega();
            }
        });

    }

    public Mega() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel() {
            // This is done for demonstration purposes
            // it would be better for the child components
            // to provide appropriate sizing hints
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 800);
            }
        };
        mainPanel.setLayout(new GridBagLayout());
        this.add(mainPanel);

        GridBagConstraints constraints = new GridBagConstraints();

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.GRAY);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 0.25;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(5, 5, 5, 5);
        mainPanel.add(topPanel, constraints);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.GREEN);

        constraints.gridy = 1;
        constraints.weighty = 0.75;
        mainPanel.add(bottomPanel, constraints);

        pack();
        setLocationRelativeTo(null);
        this.setVisible(true);

    }

}