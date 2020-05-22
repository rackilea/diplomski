import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
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
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(new TestPane()));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private GridBagConstraints gbc;

        public TestPane() {
            setLayout(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            add(createPanel("I be the flip panel"), gbc);
            gbc.weighty = 0;

            add(createPanel("Item Pane 01"), gbc, getComponentCount() - 1);
            add(createPanel("Item Pane 02"), gbc, getComponentCount() - 1);
            add(createPanel("Item Pane 03"), gbc, getComponentCount() - 1);
        }

        protected JPanel createPanel(String text) {
            return new SubPanel(text);
        }

        public class SubPanel extends JPanel {

            public SubPanel(String text) {
                setLayout(new BorderLayout());
                add(new JLabel(text));
                setBorder(new LineBorder(Color.RED));
            }

            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.height = 100;
                return size;
            }

            @Override
            public Dimension getMinimumSize() {
                return getPreferredSize();
            }

        }

    }

}