import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TestTwoTimers extends JPanel {

    int rectOneX = 0;
    int rectTwoX = 0;

    Timer timer1 = new Timer(100, null);
    Timer timer2 = new Timer(100, null);
    boolean rectOneGo = true;



    public TestTwoTimers() {
        timer1 = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rectOneGo) {
                    if (rectOneX >= 225) {
                        timer2.start();
                        timer1.stop();
                    } else {
                        rectOneX += 10;
                        repaint();
                    }
                }
            }
        });
        timer2 = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rectTwoX < 225) {
                    rectTwoX += 10;
                    repaint();
                } else {
                    timer2.stop();
                }
            }
        });

        final JButton button = new JButton("Start First Timer");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                timer1.start();
            }
        });

        setLayout(new BorderLayout());
        add(button, BorderLayout.PAGE_END);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);
        g.fillRect(rectOneX, 50, 75, 75);

        g.setColor(Color.BLUE);
        g.fillRect(rectTwoX, 150, 75, 75);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new JFrame("Double Timers");
                frame.add(new TestTwoTimers());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}