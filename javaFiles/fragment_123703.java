import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TableExample {

    public static void main(String[] args) {
        new TableExample();
    }

    public TableExample() {
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

        private JPanel fieldsPanel;
        private JPanel filler;
        private int row;

        public TestPane() {
            setLayout(new BorderLayout());

            filler = new JPanel();
            fieldsPanel = new JPanel(new GridBagLayout());
            add(new JScrollPane(fieldsPanel));

            JButton btn = new JButton("Add");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fieldsPanel.remove(filler);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.insets = new Insets(2, 2, 2, 2);
                    gbc.gridx = 0;
                    gbc.gridy = row;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    fieldsPanel.add(new JLabel("Row " + (++row)), gbc);
                    gbc.gridx++;
                    gbc.weightx = 1;
                    fieldsPanel.add(new JTextField(10), gbc);

                    gbc.gridy++;
                    gbc.weighty = 1;
                    fieldsPanel.add(filler, gbc);
                    fieldsPanel.revalidate();
                }
            });
            add(btn, BorderLayout.SOUTH);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

}