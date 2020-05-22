import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JSmileFacePanel2 extends JFrame {

    private static final long serialVersionUID = 1L;

    // by default should show smiling
    private boolean doSmile = true;

    JButton smile = new JButton("SMILE");
    JButton frown = new JButton("FROWN");

    public JSmileFacePanel2() {
        setLayout(new FlowLayout());
        setTitle("JSmileFace-V2: Jose M. Tobar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(frown);
        add(smile);

        smile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("SMILE BUTTON CLICKED");
                doSmile = true;
                repaint();
            }
        });

        frown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("FROWN BUTTON CLICKED");
                doSmile = false;
                repaint();
            }
        });

        setSize(800, 800);
        setVisible(true);
    }

    public void paint(final Graphics g) {
        super.paint(g);

        if (doSmile) {
            drawSmile(g);
        } else {
            drawFrown(g);
        }
    }

    public void drawSmile(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(200, 200, 500, 500);
        g.setColor(Color.BLUE);
        g.fillOval(300, 360, 50, 50);
        g.setColor(Color.BLUE);
        g.fillOval(600, 360, 50, 50);
        g.drawArc(400, 400, 100, 40, 180, 185);
    }

    public void drawFrown(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(200, 200, 500, 500);
        g.setColor(Color.BLUE);
        g.fillOval(300, 360, 50, 50);
        g.setColor(Color.BLUE);
        g.fillOval(600, 360, 50, 50);
        g.drawArc(400, 400, 100, 40, 180, 185);
    }

    public static void main(String[] args) {
        JSmileFacePanel2 js = new JSmileFacePanel2();
    }

}