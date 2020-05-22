class LineSegment extends Shape implements Comparable<LineSegment>{
    public int getArea() {...}

    public int compareTo(LineSegment object1)
    {

        return Double.compare(this.getArea(), object1.getArea());
    }
}