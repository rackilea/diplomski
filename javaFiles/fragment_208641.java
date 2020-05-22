import static java.lang.Math.sin;
import static java.lang.Math.cos;

public class Coord {
    private double x,y,z;
    public Coord(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Coord M(Coord[] M) {
        return new Coord(
                x*M[0].x + y*M[0].y + z*M[0].z,
                x*M[1].x + y*M[1].y + z*M[1].z,
                x*M[2].x + y*M[2].y + z*M[2].z);
    }
    public Coord xR(double t) {
        return M(new Coord[]{V(1,0,0), V(0,cos(t),-sin(t)), V(0,sin(t),cos(t))});
    }
    public Coord yR(double t) {
        return M(new Coord[]{V(cos(t),0,sin(t)), V(0,1,0), V(-sin(t),0,cos(t))});
    }
    public Coord zR(double t) {
        return M(new Coord[]{V(cos(t),-sin(t),0), V(sin(t),cos(t),0), V(0,0,1)});
    }
    public Coord V(double x, double y, double z) {
        return new Coord(x,y,z);
    }
}