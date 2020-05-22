public class YourEntityShape{

    private Point p1, p2, p3, p4, p5, p6;

    public YourEntityShape(Point p1, Poin...... etc.){
        this.p1 = p1;
        this.p2 = p2;
        //etc....
    }

    //Getter for private Points
    public Point getP1(){
        return p1;
    }
    //etc..

    public boolean overlaps(OtherEntityShape s){
        //Your collision detection code...
    }
}