import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridx = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(4, 4, 4, 4);

            for (int row = 0; row < 9; row++) {
                gbc.gridy = row;
                for (int col = 0; col < 9; col++) {
                    gbc.gridx = col;
                    if (row % 2 == 0) {
                        if (col % 2 == 0) {
                            add(bigButton(), gbc);
                        } else {
                            add(verticalButton(), gbc);
                        }
                    } else if (col % 2 == 0) {
                        add(horizontalButton(), gbc);
                    }
                }
            }
        }

        protected JButton bigButton() {
            JButton btn = new JButton() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(100, 100);
                }
            };
            return btn;
        }

        protected JButton verticalButton() {
            JButton btn = new JButton() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(45, 100);
                }
            };
            return btn;
        }

        protected JButton horizontalButton() {
            JButton btn = new JButton() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(100, 45);
                }
            };
            return btn;
        }
    }

}