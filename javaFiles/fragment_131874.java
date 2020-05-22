public static void main(String[] args) {
    Area a = new Area(new Rectangle(1, 1, 5, 5));
    PathIterator iterator = a.getPathIterator(null);
    float[] floats = new float[6];
    Polygon polygon = new Polygon();
    while (!iterator.isDone()) {
        int type = iterator.currentSegment(floats);
        int x = (int) floats[0];
        int y = (int) floats[1];
        if(type != PathIterator.SEG_CLOSE) {
            polygon.addPoint(x, y);
            System.out.println("adding x = " + x + ", y = " + y);
        }
        iterator.next();
    }
}