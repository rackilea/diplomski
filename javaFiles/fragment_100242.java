Rectangle2D bounds = null;
float[] coords = new float[6];
for (PathIterator i = shape.getPathIterator(null, 1);
     !i.isDone();
     i.next()) {

    if (i.currentSegment(coords) != PathIterator.SEG_CLOSE) {
        float x = coords[0];
        float y = coords[1];
        if (bounds == null) {
            bounds = new Rectangle2D.Float(x, y, 0, 0);
        } else {
            bounds.add(x, y);
        }
    }
}
System.err.println( "Bounds: " + bounds );