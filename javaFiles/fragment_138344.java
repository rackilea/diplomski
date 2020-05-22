public class MyRetangle{
    int x = 10;
    int y = 10;
    int width = 100;
    int height = 100;
    Color color = Color.RED;

}

public class Surface extends JPanel {
    MyRectangle rect = new MyRectangle();  // create an instance of your other class

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(rect.color);      // use data from rect
        g2.draw(new Rectangle.Double(rect.x, rect.y, rect.width, rect.height));
    }
}