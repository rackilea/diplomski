public void processPoints(Point point) {
    process(point.x);
    process(point.y);
    if (point instanceof Point3D) {
        Point3D point3d = (Point3D) point;
        process(point3d.z);
    }
}