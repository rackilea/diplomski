import javax.swing.*;
   import java.awt.*;
   import java.awt.event.MouseEvent;
   import java.awt.event.MouseListener;
   public class MyTriangle{
   static  JFrame frame = new JFrame();
   public static void main(String[] args)
    {
    frame.setSize(1000, 1500);
    frame.setTitle("Triangle Draw");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //add panel to frame and make it visible
    Polygon triangle1 = new Polygon();
    triangle1.addPoint(100, 500); // first
    triangle1.addPoint(600, 500);//last
    triangle1.addPoint(350, 300);//middel
    addTriangle(new Triangle(triangle1));
    frame.setVisible(true);
}

public static void addTriangle(Triangle triangle1)
{
    frame.add(triangle1);
}
static class Triangle extends JPanel implements MouseListener{
    private Polygon triangle;

    public Triangle(Polygon triangle)
    {
        this.triangle = triangle;

        addMouseListener(this);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.draw(triangle);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        if(triangle.contains(p))
        {
            Polygon triangle2 = new Polygon();
            triangle2.addPoint(200, 300);
            triangle2.addPoint(200, 200);
            triangle2.addPoint(300, 200);
            MyTriangle.addTriangle(new Triangle(triangle2));
            Graphics2D g2d = (Graphics2D)this.getGraphics();
            g2d.draw(triangle2);
        }
    }


}