import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
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

        private JSlider slider; //declare slider
        private DrawPane myPanel; 
        public ControlPane() {
            setLayout(new BorderLayout());
            myPanel = new DrawPane();
            myPanel.setBackground(Color.cyan); //change background color

            slider = new JSlider(SwingConstants.VERTICAL, 0, 400, 100);// restrains the slider from scaling square to 0-300 pixels
            slider.setMajorTickSpacing(20); //will set tick marks every 10 pixels
            slider.setPaintTicks(true); //this actually paints the ticks on the screen

            slider.addChangeListener(
                    new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                            myPanel.setScale(slider.getValue()); //Wherever you set the slider, it will pass that value and that will paint on the screen
                        }
                    }
            );

            JSlider rotate = new JSlider(SwingConstants.VERTICAL, 0, 720, 0);
            rotate.setMajorTickSpacing(20); //will set tick marks every 10 pixels
            rotate.setPaintTicks(true); //this actually paints the ticks on the screen

            rotate.addChangeListener(
                    new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                            JSlider slider = (JSlider) e.getSource();
                            myPanel.setAngle(slider.getValue()); 
                        }
                    }
            );
            add(slider, BorderLayout.WEST);
            add(rotate, BorderLayout.EAST);

            add(myPanel);

            myPanel.setScale(400);
        }

    }

    public class DrawPane extends JPanel {

        private double scale = 1;
        private double angle = 0;

        private final int rectWidth = 20;
        private final int rectHeight = 20;


        @Override
        protected void paintComponent(Graphics g)//paints obj on the screen
        {
            super.paintComponent(g); //prepares graphic object for drawing

            int originX = getWidth() / 2; 
            int originY = getHeight() / 2;

            int xOffset = -(rectWidth / 2);
            int yOffset = -(rectHeight / 2);

            g.setColor(Color.BLACK);
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.translate(originX, originY);
            g2d.scale(scale, scale);
            g2d.rotate(Math.toRadians(angle), 0, 0);

            g2d.fill(new Rectangle2D.Double(xOffset, yOffset, rectWidth, rectHeight));
            g2d.dispose();

            g.setColor(Color.RED);
            g.drawRect(originX + xOffset, originY + yOffset, rectWidth, rectWidth);
        }

        public void setAngle(double angle) {
            this.angle = angle;
            repaint();
        }

        public void setScale(int scale) {
            // Scaling is normalized so that 1 = 100%
            this.scale = (scale / 100d);
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}