import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TextAreaSize {

    public static void main(String[] args) {
        new TextAreaSize();
    }

    public TextAreaSize() {
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

        private JTextArea ta;

        public TestPane() {

            setLayout(new GridBagLayout());

            JRadioButton btnSmall = new JRadioButton(new SizeAction("Small", 2, 10));
            JRadioButton btnMed = new JRadioButton(new SizeAction("Medium", 4, 15));
            JRadioButton btnLarge = new JRadioButton(new SizeAction("Large", 12, 24));
            ButtonGroup bg = new ButtonGroup();
            bg.add(btnSmall);
            bg.add(btnMed);
            bg.add(btnLarge);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            add(btnSmall, gbc);
            gbc.gridy++;
            add(btnMed, gbc);
            gbc.gridy++;
            add(btnLarge, gbc);

            gbc.gridx++;
            gbc.gridy = 0;
            gbc.gridheight = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.CENTER;
            ta = new JTextArea();
            add(new JScrollPane(ta), gbc);

            btnSmall.doClick();

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public class SizeAction extends AbstractAction {

            private int rows;
            private int columns;

            public SizeAction(String name, int rows, int columns) {
                putValue(NAME, name);
                this.rows = rows;
                this.columns = columns;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setRows(rows);
                ta.setColumns(columns);
                revalidate();
            }
        }
    }        
}