public class ParallelogramPerimeter implements mxPerimeterFunction {
    @Override
    public mxPoint apply(mxRectangle bounds, mxCellState vertex, mxPoint next,
            boolean orthogonal) {
        double cx = bounds.getCenterX();
        double cy = bounds.getCenterY();
        double nx = next.getX();
        double ny = next.getY();
        double pi = Math.PI;
        double pi2 = Math.PI/2.0;
        double h = bounds.getHeight();
        double w = bounds.getWidth();
        double alpha = Math.atan2(h/2.0, w/2.0+h/4.0);
        double beta = Math.atan2(h/2.0, w/2.0-h/4.0);
        double t = Math.atan2(ny-cy, nx-cx);

        mxPoint p = new mxPoint();

        //Left
        if (t > pi - alpha || t < (-pi)+beta){
            Line border = new Line(cx-w/2.0+h/4.0, cy-h/2.0, cx-w/2.0-h/4.0, cy+h/2.0);
            Line line = new Line(cx, cy, nx, ny);
            p = Line.intersection(border, line);
        }
        //Top
        else if (t > (-pi)+beta && t < (0-alpha)){
            p.setY(cy-h/2.0);
            p.setX(cx + h/2.0*Math.tan(pi2+t));
        }
        //Right
        else if (t > (0-alpha) && t < beta){
            Line border = new Line(cx+w/2.0+h/4.0, cy-h/2.0, cx+w/2.0-h/4.0, cy+h/2.0);
            Line line = new Line(cx, cy, nx, ny);
            p = Line.intersection(border, line);
        }
        //Bottom
        else {
            p.setY(cy+h/2.0);
            p.setX(cx + h/2.0*Math.tan(pi2-t));
        }

        if (orthogonal){
            //Top
            if (nx >= cx-w/2.0+h/4.0 && nx <= cx+w/2.0+h/4.0 && ny <= cy-h/2.0){
                p.setX(nx);
            }
            //Bottom
            else if (nx >= cx - w/2.0-h/4.0 && nx <= cx+w/2.0-h/4.0 && ny >= cy+h/2.0){
                p.setX(nx);
            }
            //Left or right
            else{
                Line left = new Line(cx-w/2.0+h/4.0, cy-h/2.0, cx-w/2.0-h/4.0, cy+h/2.0);
                Line right = new Line(cx+w/2.0+h/4.0, cy-h/2.0, cx+w/2.0-h/4.0, cy+h/2.0);
                p = left.projection(nx, ny);
                mxPoint p1 = right.projection(nx, ny);
                boolean r = false;
                if (distance(nx, ny, p.getX(), p.getY()) > distance(nx, ny, p1.getX(), p1.getY()))
                    {
                        p = p1;
                        r = true;
                    }
                //Upper corners
                if (p.getY() < cy-h/2.0){
                    p.setY(cy-h/2.0);
                    if(r){
                        p.setX(cx+w/2.0+h/4.0);
                    }
                    else
                    {
                        p.setX(cx-w/2.0+h/4.0);
                    }
                }
                //Lower corners
                else if (p.getY() > cy+h/2.0){
                    p.setY(cy+h/2.0);
                    if(r){
                        p.setX(cx+w/2.0-h/4.0);
                    }
                    else
                    {
                        p.setX(cx-w/2.0-h/4.0);
                    }
                }
            }
        }

        return p;

    }

    private double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
    }

}

class Line{
private double a;
private double b;
private double c;

Line(double x1, double y1, double x2, double y2){
    a = y1-y2;
    b = x2-x1;
    c = x1*y2-x2*y1;
}

private Line(double a, double b, double c){
    this.a = a;
    this.b = b;
    this.c = c;
}

static private double determinant(double i, double j, double k, double l){
    return i*l - k*j;
}

static mxPoint intersection(Line first, Line second){
    double x,y;
    double denominator = determinant(first.a, first.b, second.a, second.b);
    x = 0 - determinant(first.c, first.b, second.c, second.b)/denominator;
    y = 0 - determinant(first.a, first.c, second.a, second.c)/denominator;
    return new mxPoint(x,y);
}

mxPoint projection(double x, double y){
    double a,b,c;
    if (this.b!=0){
        a=1;
        b=-(this.a*a)/this.b;
    }
    else{
        b = 1;
        a=-(this.b*b)/this.a;
    }
    c = -(a*x+b*y);
    Line line = new Line(a,b,c);
    return intersection(this, line);
}
}