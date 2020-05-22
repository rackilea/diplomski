import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StairWayToHeven {

    public static void main(String[] args) {
        new StairWayToHeven();
    }

    public StairWayToHeven() {
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

        private int numSteps = 4;

        public TestPane() {
            setBorder(new EmptyBorder(4, 4, 4, 4));
            setLayout(new BorderLayout());

            final JSlider slider = new JSlider(2, 20);
            slider.setOpaque(false);
            slider.setValue(4);
            add(slider, BorderLayout.SOUTH);
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    numSteps = slider.getValue();
                    repaint();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 

            Insets insets = getInsets();
            int width = getWidth() - (insets.left + insets.right);
            int height = getHeight() - (insets.top + insets.bottom);

            int stepWidth = Math.round((float)width / (float)numSteps);
            int stepHeight = Math.round((float)height / (float)numSteps);

            g.setColor(Color.BLACK);
            for (int step = 0; step < numSteps; step++) {
                int fromX = insets.left + (stepWidth * step);
                int fromY = insets.top + (stepHeight * step);
                int toX = insets.left + (stepWidth * (step + 1));
                int toY = insets.top + (stepHeight * (step + 1));

                g.drawLine(fromX, fromY, toX, fromY);
                g.drawLine(toX, fromY, toX, toY);
            }
        }
    }
}