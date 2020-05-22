import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Test {

    public static void main(String[] args) {
        JFrame f = new JFrame("Test");
        MyPanel c = new MyPanel();
        f.getContentPane().add(c);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(350, 100);
        f.setVisible(true);
    }

}

class MyPanel extends JPanel {

    int x = 0;
    boolean toTheRight = true;

    public MyPanel() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    x = (toTheRight)?x+5:x-5;
                    if (x>300)
                        toTheRight = false;
                    if (x<0)
                        toTheRight = true;
                    repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setPaint(Color.red);
        g2.fillOval(x-2, 50, 4, 4);
    }

}