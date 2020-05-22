import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Parker {

    public static void main(String[] args) {
        new Parker();
    }

    public Parker() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new ControlPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ControlPane extends JPanel {

        private JSlider slider;
        private DrawPane myPanel;

        public ControlPane() {
            setLayout(new BorderLayout());
            myPanel = new DrawPane();
            myPanel.setBackground(Color.WHITE);
            Dimension dim = myPanel.getSize();

            addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(ComponentEvent e) {
                    Dimension dim = e.getComponent().getSize();
                    myPanel.resizeRectangle(dim.width / 2, dim.height / 2);
                }

            });

            slider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 20);
            slider.setMajorTickSpacing(20);
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
            slider.setValue(0);

            slider.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Slider"),
                    BorderFactory.createEmptyBorder(15, 10, 15, 10)));

            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    myPanel.setScale(slider.getValue());
                }
            });

            add(slider, BorderLayout.SOUTH);
            add(myPanel, BorderLayout.CENTER);

        }

    }

    public class DrawPane extends JPanel {

        double scale = 1;
        double angle = 0;

        int rectWidth = 50;
        int rectHeight = 50;

        public void componentResized(ComponentEvent e) {
            Dimension newSize = e.getComponent().getBounds().getSize();
        }

        public void resizeRectangle(int width, int height) {
            rectWidth = width;
            rectHeight = height;
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            int originX = getWidth() / 2;
            int originY = getHeight() / 2;

            int xOffset = -(rectWidth / 2);
            int yOffset = -(rectHeight / 2);

            g.setColor(Color.BLACK);
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.translate(originX, originY);
            g2d.scale(scale, scale);

            g2d.fill(new Rectangle2D.Double(xOffset, yOffset, rectWidth, rectHeight));
            g2d.dispose();

            g.setColor(Color.RED);
            g.drawRect(originX + xOffset, originY + yOffset, rectWidth, rectWidth);
        }

        public void setScale(int scale) {
            this.scale = (scale / 100d);
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 200);
        }

    }

}