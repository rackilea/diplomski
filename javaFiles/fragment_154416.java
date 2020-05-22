public class pointD extends PointF{

public double x;
public double y;

public pointD(double x, double y){
    this.set((float) x,(float) y);
    this.x = x;
    this.y = y;
}

public double Length(){
    double l = (double)this.length();
    return l;
}

public final void set(double x, double y){
    this.set((float) x,(float) y);
    this.x = x;
    this.y = y;
}
}