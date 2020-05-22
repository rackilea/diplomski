import processing.core.*;

public class Site {
    public static final int COUNT       = 8;
    public static final int MAX_VEL     = 2;
    public static final int MARKER_SIZE = 6;

    PApplet parent;

    float x, y;
    PVector vel;

    int c;

    Site(PApplet p) {
        parent = p;
        vel = new PVector(
            parent.random(-MAX_VEL, MAX_VEL),
            parent.random(-MAX_VEL, MAX_VEL)
        );     
    }   
}