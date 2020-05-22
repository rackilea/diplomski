Iterator<Point> firstIter = results.iterator();
while(firstIter.hasNext()) {
    Point p1 = iterator.next();

    Iterator<Point> secondIter = results.iterator();
    while(secondIter.hasNext()) {
        Point p2 = secondIter.next();

        if(...) {
            secondIter.remove();
        }
    }
}