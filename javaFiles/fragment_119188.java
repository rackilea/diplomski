import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

public class CarMove extends JComponent

{

    private volatile boolean drawCar = false;

    private int lastX = 0;

    private int x = 1;
    // create the car from draw class
    Car car1 = new Car(x, 320);

    {

        FrameMouseListener listener = new FrameMouseListener();
        super.addMouseListener(listener);
    }

    public void paintComponent(Graphics g)
    {

        Graphics2D g2 = (Graphics2D) g;

        int carSpeed = 1;
        int w = getWidth();
        x = lastX + carSpeed;
        if (x == w - 60)
        {
            x = x - carSpeed;
        }
        if (drawCar)
        {
            car1.draw(g2);
        }

        lastX = x;
    }

    public class FrameMouseListener extends MouseAdapter
    {

        @Override
        public void mouseClicked(MouseEvent e)
        {
            drawCar = true;
            repaint();
        }
    }

}