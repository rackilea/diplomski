public class DrawRect{
    int y;
    int y;
    int height;
    int width;
    Color color;

    public DrawRect(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
}

public class Surface extends JPanel {

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        DrawRect rect = new DrawRect(20, 20, 100, 100, Color.RED);
        g2.setColor(rect.color); 
        g2.draw(new Rectangle.Double(rect.x, rect.y, rect.width, rect.height));
    }
}