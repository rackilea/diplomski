import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class BadLayout21 {

    public static void main(String[] args) {
        new BadLayout21();
    }

    public BadLayout21() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {

            setBorder(new EmptyBorder(10, 10, 10, 10));

            setLayout(new GridBagLayout());

            JPanel leftPane = new JPanel(new GridLayout(2, 0, 0, 4));
            leftPane.add(createPane(Color.RED));
            leftPane.add(createPane(Color.RED));

            JPanel leftMiddlePanel = createPane(Color.BLUE);
            JPanel rightMiddlePanel = createPane(Color.BLUE);

            JPanel rightPane = new JPanel(new GridLayout(2, 0, 0, 4));
            rightPane.add(createPane(Color.GREEN));
            rightPane.add(createPane(Color.GREEN));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1;
            gbc.insets = new Insets(20, 20, 0, 0);
            add(leftPane, gbc);

            gbc.gridx = 3;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.insets = new Insets(20, 0, 0, 20);
            add(rightPane, gbc);

            gbc.weightx = 0;
            gbc.gridx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.insets = new Insets(0, 0, 0, 10);
            add(leftMiddlePanel, gbc);

            gbc.gridx = 2;
            gbc.insets = new Insets(0, 10, 0, 0);
            add(rightMiddlePanel, gbc);

        }

        protected JPanel createPane(Color color) {
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(25, 25));
            panel.setBackground(color);
            return panel;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }
}