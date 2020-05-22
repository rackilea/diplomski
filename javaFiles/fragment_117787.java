Arrays.sort(p, new Comparator<Point>() {
    int compare(Point a, Point b) {
        int xComp = Integer.compare(a.x, b.x);
        if(xComp == 0)
            return Integer.compare(a.y, b.y);
        else
            return xComp;
    }
});