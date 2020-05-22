public static void dump(Shape shape) {
    float[] coords = new float[6];
    PathIterator pathIterator = shape.getPathIterator(new AffineTransform());
    while (!pathIterator.isDone()) {
        switch (pathIterator.currentSegment(coords)) {
        case PathIterator.SEG_MOVETO:
            System.out.printf("move to x1=%f, y1=%f\n",
                    coords[0], coords[1]);
            break;
        case PathIterator.SEG_LINETO:
            System.out.printf("line to x1=%f, y1=%f\n",
                    coords[0], coords[1]);
            break;
        case PathIterator.SEG_QUADTO:
            System.out.printf("quad to x1=%f, y1=%f, x2=%f, y2=%f\n",
                    coords[0], coords[1], coords[2], coords[3]);
            break;
        case PathIterator.SEG_CUBICTO:
            System.out.printf("cubic to x1=%f, y1=%f, x2=%f, y2=%f, x3=%f, y3=%f\n",
                    coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
            break;
        case PathIterator.SEG_CLOSE:
            System.out.printf("close\n");
            break;
        }
        pathIterator.next();
    }    
}