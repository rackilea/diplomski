PathIterator pi = path.getPathIterator(null);
float[] value = new float[6];
float x = 0, y = 0;

while (!pi.isDone()) {
    int type = pi.currentSegment(values);
    if (type == PathIterator.SEG_LINETO) {
        x = values[0];
        y = values[1];
    }
    else if (type == PathIterator.SEG_CLOSE) {
        x = 0;
        y = 0;
    }
    else {
        // SEG_MOVETO, SEG_QUADTO, SEG_CUBICTO
    }
    pi.next();
}