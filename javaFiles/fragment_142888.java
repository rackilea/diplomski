package main;

import javax.media.j3d.Transform3D;
import javax.vecmath.Point3d;

public class Sneeze {        
    public void test() {
        Point3d p3 = new Point3d(7, 4, 2);
        Transform3D t = new Transform3D();
        t.transform(p3);
    }
}