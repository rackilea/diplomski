import java.awt.Graphics;

public class RectangularPrism {

    protected Point3D originPoint;
    protected Point3D xPoint;
    protected Point3D yPoint;
    protected Point3D zPoint;

    public RectangularPrism() {

    }

    public RectangularPrism(Point3D originPoint, Point3D xPoint, 
            Point3D yPoint, Point3D zPoint) {
        this.originPoint = originPoint;
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.zPoint = zPoint;
    }

    public void setOriginPoint(Point3D originPoint) {
        this.originPoint = originPoint;
    }

    public void setxPoint(Point3D xPoint) {
        this.xPoint = xPoint;
    }

    public void setyPoint(Point3D yPoint) {
        this.yPoint = yPoint;
    }


    public void setzPoint(Point3D zPoint) {
        this.zPoint = zPoint;
    }

    public void render(Graphics g, Point3D viewPoint) {

    }

    public class Point3D {
        protected int x;
        protected int y;
        protected int z;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }

    }

}