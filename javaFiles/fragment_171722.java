public class Objects{
    Area shape;
    Color color;

    public Objects(int x,int y){
        this.shape= new Area (new Ellipse2D.Float(x, y, 70, 70));
        color = randColor();
    }
...
}