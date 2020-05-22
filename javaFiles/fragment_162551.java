import javax.swing.*;
import java.awt.*;
public class MyPanel extends JPanel{
    public void paintComponent(Graphics g){  
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawRect(20,20,20,20);
        g2.setColor(Color.blue);
        g2.fillOval(50,20,20,20);
        g2.drawString("Hello World", 120, 50);
    }//end painComponent 
}//end test class