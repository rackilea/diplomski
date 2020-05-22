chunkedPoints.add(points[0]);
for(int i = 0; i < points.length-1; i++) { //Skip the last element
    Point newPoint;
    do {
        //chunking
        newPoint = new Point(nx, ny);
        chunkedPoints.add(newPoint);
    } while(!newPoint.equals(points[i+1]));
}
chunkedPoints.add(points[points.length-1]); //Add the last element