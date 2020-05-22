import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JavaApplication57 {

    public static void main(String[] args) {
        new JavaApplication57();
    }

    public JavaApplication57() {
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
            CustomScroll comp = new CustomScroll();
            comp.setPreferredScrollableViewportSize(new Dimension(100, 100));

            comp.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.insets = new Insets(5, 10, 10, 5);
            for (int index = 0; index < 100; index++) {

                JButton btn = new JButton("Hello world " + index);
                comp.add(btn, gbc);

            }

            add(new JScrollPane(comp));
        }

    }

    public class CustomScroll extends JComponent implements Scrollable {

        private Dimension preferredScrollableViewportSize = new Dimension(266, 300);

        public CustomScroll() {
        }

        public void setPreferredScrollableViewportSize(Dimension size) {
            this.preferredScrollableViewportSize = size;
        }

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return preferredScrollableViewportSize;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect,
                        int orientation, int direction) {
            return 64;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return false;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return false;
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect,
                        int orientation, int direction) {
            return 64;
        }
    }
}