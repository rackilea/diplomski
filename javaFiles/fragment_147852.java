List<Point> result = new ArrayList<>();
int lowerX = points.ceilingKey(x - c);
int upperX = points.floorKey(x + c);
for each x coordinate in points.entrySet().subset(lowerX, upperX)
    TreeSet<Integer> yCoordinates = points.get(x);
    lowerY = yCoordinates.ceiling(y - c);
    upperY = yCoordinates.ceiling(y + c);

    for each y coordinate in yCoordinates.subset(lowerY, upperY)
       result.add(new Point(x, y))