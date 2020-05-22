public Point2d getPosition2d(Point3d point) {
    Transform3D transform = new Transform3D();
    getVworldToImagePlate(transform);
    transform.mul(objectTransform);

    Point3d newPoint = new Point3d(point);
    transform.transform(newPoint);

    Point2d point2d = new Point2d();
    getPixelLocationFromImagePlate(newPoint, point2d);
    return point2d;
}