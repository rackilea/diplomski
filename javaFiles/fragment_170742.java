import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JCheckBox;
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

        private JCheckBox[] checkBoxes;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = gbc.BOTH;
            gbc.weightx = 1;
            gbc.weighty = 1;

            checkBoxes = new JCheckBox[4];
            for (int index = 0; index < 4; index++) {
                checkBoxes[index] = new JCheckBox();
                checkBoxes[index].setOpaque(false);
                checkBoxes[index].setHorizontalAlignment(JCheckBox.CENTER);
            }

            // Base
            gbc.gridx = 1;
            gbc.gridy = 2;
            add(checkBoxes[0], gbc);

            // First
            gbc.gridx = 2;
            gbc.gridy = 1;
            add(checkBoxes[1], gbc);

            // Second
            gbc.gridx = 1;
            gbc.gridy = 0;
            add(checkBoxes[2], gbc);

            // Third
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(checkBoxes[3], gbc);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected Point center(Rectangle bounds) {
            Point point = new Point();
            point.x = bounds.x + (bounds.width / 2);
            point.y = bounds.y + (bounds.height / 2);
            return point;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            Point from = center(checkBoxes[0].getBounds());
            for (int index = 1; index < checkBoxes.length; index++) {
                Rectangle bounds = checkBoxes[index].getBounds();
                Point to = center(bounds);
                g2d.drawLine(from.x, from.y, to.x, to.y);
                from = to;
            }
            Point to = center(checkBoxes[0].getBounds());
            g2d.drawLine(from.x, from.y, to.x, to.y);
            g2d.dispose();
        }

    }

}