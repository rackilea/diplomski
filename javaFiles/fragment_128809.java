import java.awt.*;
import javax.swing.*;

public class StartCircles extends JFrame{
private static final long serialVersionUID = 1L;

private Circles circle;
public StartCircles(){
    Container c = getContentPane();
    circle = new Circles();
    c.setBackground(Color.white);
    c.setLayout(new FlowLayout());
    //setSize(300, 300);
    c.add(circle);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack(); // size the GUI to the components within it
}

public static void main(String[] args){
    StartCircles c1 = new StartCircles();
}
}

class Circles extends JPanel {
private static final long serialVersionUID = 1L;

public Circles(){
    setBackground(Color.white);
    setPreferredSize(new Dimension(300, 300));
}

public void paintComponent(Graphics g){
    //super.paintComponents(g);  // WRONG METHOD!
    super.paintComponent(g);
    g.setColor(Color.black);
    g.drawRect(10, 10, 50, 50);
}
}