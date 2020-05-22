import java.awt.*;
import javax.swing.*;

public class Draw extends JPanel{
    private boolean paintRectangle = false;

    void setPaintRectangle(boolean p) {
        paintRectangle = p;
        repaint();
    }

    @Override
    public void paintComponent(){
        super.paintComponent(g);

        if (paintRectangle) {
            g.setColor(Color.BLUE);
            g.fillRect(10,15,100,100);
        }
    }
}