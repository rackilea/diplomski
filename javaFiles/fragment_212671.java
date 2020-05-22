import javax.swing.*;
import java.awt.*;

public class Infout extends JFrame{
    Infout(){
        setSize(300, 400);
        setTitle("An Empty Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
         Infout m = new Infout();
         m.repaint(); 
    }

    @Override
    public void paint(Graphics g) 
    {
         g.drawRect(5, 5, 105, 105);
    }

}