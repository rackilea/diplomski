import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setUndecorated(true);
                frame.setBackground(new Color(0, 0, 0, 0));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new MainPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MainPane extends JPanel {

        public MainPane() {
            setOpaque(false);
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 0.5;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.NORTH;
            add(new FieldsPane(), gbc);

            gbc.gridx++;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            add(new JScrollPane(new JTextArea(20, 20)), gbc);
        }

    }

    public class FieldsPane extends JPanel {

        private JPanel fields;
        private JLabel filler;

        public FieldsPane() {
            setBorder(new LineBorder(Color.GRAY));
            fields = new JPanel(new GridBagLayout());
            filler = new JLabel();
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weighty = 1;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            fields.add(filler, gbc);

            addFields(new JLabel("Col1"), new JLabel("Col2"), new JLabel("Col3  "));
            addFields(new JTextField(10), new JTextField(10), new JTextField(10));

            setLayout(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            add(fields, gbc);

            JPanel buttons = new JPanel(new GridBagLayout());
            JButton add = new JButton("Add");
            JButton remove = new JButton("Remove");
            buttons.add(add);
            buttons.add(remove);

            gbc.gridy++;
            gbc.weightx = 1;
            gbc.weighty = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(buttons, gbc);
        }

        protected void addFields(JComponent col1, JComponent col2, JComponent col3) {
            GridBagLayout layout = (GridBagLayout) fields.getLayout();
            GridBagConstraints gbc = layout.getConstraints(filler);
            fields.add(makeRow(col1, col2, col3), gbc);

            gbc.gridy++;
            layout.setConstraints(filler, gbc);
        }

        protected JPanel makeRow(JComponent col1, JComponent col2, JComponent col3) {
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridy = 0;
            gbc.weightx = 0.33;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel.add(col1, gbc);
            panel.add(col2, gbc);
            panel.add(col3, gbc);
            return panel;
        }

    }

}