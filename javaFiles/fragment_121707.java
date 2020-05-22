public PolygonImpl(Point[] points) {
    //some code here...
    for (int i = 0; i < cloneList.length; i++) {
        //create the new Point instance (the clone) here
        //this code is just an example since you haven't provided the Point constructor
        cloneList[i] = new Point(points[i].getX(), points[i].getY());
    }
    //some more code here...
}