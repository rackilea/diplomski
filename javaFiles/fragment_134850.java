public class Rect {

    private int x;
    private int y;
    private int width;
    private int height;

    public Rect() {
        random=new Random();
        x=random.nextInt(400);
        y=random.nextInt(400);
        width=20;
        height=20;
    }
    //getters and setters
}


private Rect rectangles[1000] = new Rect[]();


public void paintComponent(Graphics g){
    super.paintComponent(g);

    for (int i=0; i<1000;i++) {
        g.drawRect(rectangles[i].getX(), rectangles[i].getY(),
                   rectangles[i].getwidth(), rectangles[i].getHeight());
    }
}