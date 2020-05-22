import java.awt.*;
import javax.swing.*;

public class GameField extends JApplet {

    @Override
    public void init() {
        // Applet is FlowLayout by default, which does not stretch components
        // let's use GridLayout instead
        setLayout(new GridLayout()); 
        add(new test());
    }
}

class test extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("draw");
        // super.paintComponents(g);  // WRONG method!  Broken paint chain
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawOval(500, 500, 100, 100);
        g.fillRect(100, 100, 100, 100);
    }
}