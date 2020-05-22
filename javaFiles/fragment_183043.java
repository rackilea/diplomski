public static void main(String[] args) {
    List<Line> drawnLines = new ArrayList<Line>();
    drawnLines.add(new Line(5, 12, 55, 66));
    Line linea = new Line(5, 12, 55, 66);
    if (drawnLines.contains(linea))
        System.out.println("contains " + linea);
    else
        System.out.println(" does not contain " + linea);
}

static class Line {
    final float x0, y0, x1, y1;

    Line(float x0, float y0, float x1, float y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        if (Float.compare(line.x0, x0) != 0) return false;
        if (Float.compare(line.x1, x1) != 0) return false;
        if (Float.compare(line.y0, y0) != 0) return false;
        return Float.compare(line.y1, y1) == 0;
    }

    @Override
    public String toString() {
        return "Line{" + "x0=" + x0 + ", y0=" + y0 + ", x1=" + x1 + ", y1=" + y1 + '}';
    }
}