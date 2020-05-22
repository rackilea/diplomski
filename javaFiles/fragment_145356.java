import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class MyMap extends JPanel {

    Color color = Color.GREEN;     <-- class member

    public MyMap(){
        Timer timer = new Timer();
        boolean semaphore =true;    <-- not sure what this is for so I left it
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                color = Color.RED;      <-- change color

                repaint();              <-- repaint();

                System.out.println("tic tac");
            }
        }, 0, 5000);
    }

    public void paintComponent(final Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 500, 250); // stanga sus
        g.fillRect(900, 0, 500, 250); // dreapta sus
        g.fillRect(0, 500, 500, 250);// stanga jos
        g.fillRect(900, 500, 500, 250); // dreapta jos

        g.setColor(Color.GRAY);
        g.fillRect(500, 0, 400, 900);
        g.fillRect(0, 250, 500, 250);
        g.fillRect(900, 250, 500, 250);

        g.setColor(Color.WHITE);
        g.fillRect(695, 0, 5, 100);// linii verticale
        g.fillRect(695, 150, 5, 100);
        g.fillRect(695, 500, 5, 100);
        g.fillRect(695, 650, 5, 50);

        g.fillRect(0, 370, 50, 5);
        g.fillRect(100, 370, 100, 5); // linii orizontale
        g.fillRect(250, 370, 100, 5);
        g.fillRect(400, 370, 100, 5);
        g.fillRect(900, 370, 100, 5);
        g.fillRect(1050, 370, 100, 5);
        g.fillRect(1200, 370, 100, 5);


        g.setColor(color);             <--- just use your color variable
        g.fillOval(700, 400, 20, 20);

    }
}