Point previous = null;
int vCount = 0, hCount = 0;
Iterator<Point> i = ...
List<Point> removablePoints = new ArrayList<>();
while (i.hasNext()) {
    Point current = i.next();
    if (previous != null) {
        if (current.x == previous.x) {
            ++hCount;
        } else {
            hCount = 1;
        }
        if (current.y == previous.y) {
            ++vCount;   
        } else {
            vCount = 1;
        }
   }
   if (vCount > 2) {
       removablePoints.add(current);
        --vCount;
   } else if (hCount > 2) {
       removablePoints.add(current);
       --hCount;
   }
   previous = current;
}