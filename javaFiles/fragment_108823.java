import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ClockFrame extends JFrame {

    public ClockFrame() {
        JPanel panel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        panel.setSize(getWidth(), getHeight());
        panel.setLayout(new GridLayout());
        setResizable(false);
        panel.setBackground(Color.MAGENTA.darker().darker());
        Hand sHand = new Hand(panel);
        panel.add(sHand);

        pack();
        setVisible(true);
    }

    class Hand extends JComponent {

        private Timer timer;
        private Dimension preferredSize = new Dimension(600, 600);
        private Calendar currentTime;
        private Image clockFace;

        public Hand(Object o) {
            setLocation(500, 500);
            ((JPanel) o).add(this);
            currentTime = Calendar.getInstance();
            try {
                clockFace = ImageIO.read(new URL(
                        "http://www.clipartbest.com/cliparts/LTK/kBp/LTKkBpRGc.png"));
            } catch (IOException ex) {
                Logger.getLogger(ClockFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            timer = new Timer(50, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    currentTime.setTime(new Date(System.currentTimeMillis()));
                    repaint();
                }
            });
            timer.start();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING, 
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(
                    RenderingHints.KEY_DITHERING, 
                    RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setColor(Color.LIGHT_GRAY);
            int size = preferredSize.width;
            g2d.fillOval((int)(size*.01), (int)(size*.01), (int)(size*.98), (int)(size*.98));
            if (clockFace!=null) {
                g2d.drawImage(clockFace, 0, 0, this);
            }
            double middle = size / 2d;
            /* Note that this is translating further drawing operations
            to the middle of the Hand container based on its preferred size,
            which is (layout manager not withstanding) also its actual size. 
            All co-ordinates in custom painting are relative to the component 
            being painted. */
            g2d.translate(middle, middle); 

            g2d.setColor(Color.CYAN.darker().darker());
            double angleHour = ((currentTime.get(Calendar.HOUR)*2*Math.PI)/12d)-(Math.PI/2);
            g2d.setStroke(new BasicStroke(6.5f));
            Line2D.Double hourHand = new Line2D.Double(0, 0, 
                    middle*.83*Math.cos(angleHour), 
                    middle*.83*Math.sin(angleHour));
            g2d.draw(hourHand);

            g2d.setColor(Color.CYAN.darker());
            double angleMin = ((currentTime.get(Calendar.MINUTE)*2*Math.PI)/60d)-(Math.PI/2);
            g2d.setStroke(new BasicStroke(4.5f));
            Line2D.Double minuteHand = new Line2D.Double(0, 0, 
                    middle*.85*Math.cos(angleMin), 
                    middle*.85*Math.sin(angleMin));
            g2d.draw(minuteHand);

            g2d.setColor(Color.CYAN);
            double angleSec = ((currentTime.get(Calendar.SECOND)*2*Math.PI)/60d)-(Math.PI/2);
            g2d.setStroke(new BasicStroke(2.5f));
            Line2D.Double secondHand = new Line2D.Double(0, 0, 
                    middle*.87*Math.cos(angleSec), 
                    middle*.87*Math.sin(angleSec));
            g2d.draw(secondHand);

            g2d.dispose();
        }

        public Dimension getPreferredSize() {
            return preferredSize;
        }
    }

    public static void main(String[] a) {
        ClockFrame c = new ClockFrame();
    }
}