import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Test");
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

            for (int y = 0; y < 20; y++) {
                gbc.gridy = y;
                for (int x = 0; x < 20; x++) {
                    gbc.gridx = x;
                    add(new Cell(), gbc);
                }
            }
        }

    }

    public class Cell extends JPanel {

        public Cell() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    colorCell();
                }
            });
            setBorder(new LineBorder(Color.GRAY));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(20, 20);
        }

        protected void colorCell() {
            if (getBackground() != Color.DARK_GRAY) {
                setBackground(Color.DARK_GRAY);
            } else {
                setBackground(null);
            }
        }

    }

}