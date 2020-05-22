import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

public class ClockFrame extends JFrame {

    public ClockFrame() {
        JPanel panel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        panel.setSize(getWidth(), getHeight());
        //panel.setLayout(null);//!important
        panel.setLayout(new GridLayout());
        setResizable(false);
        panel.setBackground(Color.BLACK);
        Hand sHand = new Hand(panel);
        panel.add(sHand);

        pack();
        setVisible(true);
    }

    class Hand extends JComponent {

        private Timer timer;
        private Dimension preferredSize = new Dimension(600, 600);
        private Calendar currentTime;

        public Hand(Object o) {
            setLocation(500, 500);
            ((JPanel) o).add(this);
            currentTime = Calendar.getInstance();

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
            System.out.println("x: " + this.getX() + " y: " + this.getY() + " w: " + this.getWidth() + " h: " + this.getHeight());
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.WHITE);
            double angle = (currentTime.get(Calendar.SECOND)*2*Math.PI)/60d;
            double middle = preferredSize.getWidth() / 2d;
            /* Note that this is translating further drawing operations
            to the middle of the Hand container based on its preferred size,
            which is (layout manager not withstanding) also its actual size. 
            All co-ordinates in custom painting are relative to the component 
            being painted. */
            g2d.translate(middle, middle); 
            Line2D.Double secondHand = new Line2D.Double(0, 0, 
                    middle*.9*Math.cos(angle), 
                    middle*.9*Math.sin(angle));
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