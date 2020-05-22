import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Draw extends JPanel {

    private static final int FRAME_HEIGHT = 400;

    private static final int FRAME_WIDTH = 400;

    private static final int RECT_WIDTH = 40;

    private static final int RECT_HEIGHT = 25;


    private static final long serialVersionUID = 1L;

    public Draw()
    {
        this.setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);

        Random r = new Random();
        int rx = r.nextInt(FRAME_WIDTH-RECT_WIDTH);
        int ry = r.nextInt(FRAME_HEIGHT-RECT_HEIGHT);
        g.fillRect(rx, ry, RECT_WIDTH, RECT_HEIGHT);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Title");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Draw d = new Draw();
        f.add(d);
        f.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        f.setVisible(true);

        Timer t = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                d.repaint();
            }
        });
        t.start();
    }
}