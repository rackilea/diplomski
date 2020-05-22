private PointF[] checkPointLocation(PointF[] points){

    double minLength = 100000000;
    double maxLength = 0;
    int minPos = 0;
    int maxPos = 0;

    for(int i = 0; i < points.length; i++){
        double vLength = Math.abs(Math.sqrt((points[i].x * points[i].x) + (points[i].y * points[i].y)));

        if(vLength < minLength) {
            minLength = vLength;
            minPos = i;
        }
        if(vLength > maxLength) {
            maxLength = vLength;
            maxPos = i;
        }
    }

    PointF topLeft = points[minPos];
    PointF bottomRight = points[maxPos];

    Log.d(TAG, "TopLeft: " + topLeft);
    Log.d(TAG, "BottomRight: " + bottomRight);

    PointF topRight = null;
    PointF bottomLeft = null;

    Arrays.sort(points, (o1, o2) -> Float.compare(o1.x, o2.x));

    for(int i = 0; i < points.length; i++){
        PointF p = points[i];
        Log.d(TAG, "Point: " + p);

        if( p.equals(topLeft) || p.equals(bottomRight))
            continue;

        if(bottomLeft == null && p.x < bottomRight.x && p.y > topLeft.y)
            bottomLeft = p;

        if(topRight == null && p.x > topLeft.x && p.y < bottomRight.y)
            topRight = p;
    }

    if(topRight == null){
        throw new NullPointerException("topRight is null");
    }
    if(bottomLeft == null){
        throw new NullPointerException("BottomLeft is null");
    }

    Log.d(TAG, "BottomLeft = " + bottomLeft);
    Log.d(TAG, "TopRight = " + topRight);

    PointF[] ccwPoints = {topLeft, bottomLeft, bottomRight, topRight};

    return ccwPoints;
}