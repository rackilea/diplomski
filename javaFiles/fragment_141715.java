import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
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

                TestPane tp = new TestPane();
                Timer timer = new Timer(40, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        float t = tp.getTransparancy() - 0.03f;
                        if (t < 0) {
                            t = 0;
                            ((Timer)e.getSource()).stop();
                        }
                        int i = tp.getI();

                        tp.setI(i - 1);
                        System.out.println(t);
                        tp.setTransparancy(t);
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(tp);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                timer.start();
            }
        });
    }

    public class TestPane extends JPanel {

        private float transparancy = 1f;
        private int i = 200;
        private int dollars;

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 200);
        }

        public void setTransparancy(float value) {
            if (transparancy != value) {
                float old = transparancy;
                this.transparancy = value;
                firePropertyChange("transparancy", old, transparancy);
                repaint();
            }
        }

        public float getTransparancy() {
            return transparancy;
        }

        public int getDollars() {
            return dollars;
        }

        public int getI() {
            return i;
        }

        public void setI(int value) {
            if (i != value) {
                float old = i;
                this.i = value;
                firePropertyChange("i", old, i);
                repaint();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
            g2d.setColor(Color.CYAN);
            g2d.setFont(g2d.getFont().deriveFont(50, 200F));
            //System.out.println(arg0.getFontMetrics());
            String string = "+$";
            Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getTransparancy());
            g2d.setComposite(c);
            g2d.drawString(string + getDollars(), 30, getI());
            g2d.dispose();
        }

    }

}