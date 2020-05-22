public class Line implements Parcelable {
    private Point start, end;

    public Line() {
    }

    public Line(Point start, Point end) {
        this.end = end;
        this.start = start;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(start, flags);
        dest.writeParcelable(end, flags);
    }

    @Override
    public int describeContents() {
        return 0xDEAF;
    }

    public static final Parcelable.Creator<Line> CREATOR = new Parcelable.Creator<Line>() {

        @Override
        public Line createFromParcel(Parcel source) {
            Line line = new Line();
            Point start = source.readParcelable(Point.class.getClassLoader());
            Point end = source.readParcelable(Point.class.getClassLoader());
            line.setStart(start);
            line.setEnd(end);
            return line;
        }

        @Override
        public Line[] newArray(int size) {
            return new Line[size];
        }
    };
}