import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class FloatingPane {

    public static void main(String[] args) {
        new FloatingPane();
    }

    public FloatingPane() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final WorkPane workPane = new WorkPane();
                JButton settings = new JButton("Settings");
                settings.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        workPane.toggleSettings();
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(workPane);
                frame.add(settings, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class WorkPane extends JLayeredPane {
        private final BackingPane backingPane;

        public WorkPane() {

            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            add(createLabel("Center", Color.BLUE), gbc);

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 0;
            gbc.weighty = 0;
            gbc.fill = GridBagConstraints.VERTICAL;
            add(createLabel("Left", Color.RED), gbc);
            gbc.gridx = 2;
            add(createLabel("Right", Color.GREEN), gbc);

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.gridheight = GridBagConstraints.REMAINDER;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.BOTH;

            backingPane = new BackingPane();
            backingPane.add(new SettingsPane());
            backingPane.setVisible(false);
            add(backingPane, gbc);

            setLayer(backingPane, DEFAULT_LAYER + 1);

        }

        public void toggleSettings() {

            backingPane.setVisible(!backingPane.isVisible());

        }

        protected JLabel createLabel(String text, Color bg) {

            JLabel label = new JLabel(text);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setOpaque(true);
            label.setBackground(bg);

            return label;

        }
    }

    public class BackingPane extends JPanel {

        public BackingPane() {
            setLayout(new GridBagLayout());
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(128, 128, 128, 192));
            g.fillRect(0, 0, getWidth(), getHeight());
        }

    }

    public class SettingsPane extends JPanel {

        public SettingsPane() {

            setBorder(new EmptyBorder(10, 10, 10, 10));
            add(new JLabel("Settings"));

        }
    }
}