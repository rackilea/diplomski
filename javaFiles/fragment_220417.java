private static class Segment implements Comparable<Segment> {
    int number, type;
    Segment(int number, int type) {
        this.number = number;
        this.type = type;
    }

    @Override
    public int compareTo(Segment s) {
        int result = Integer.compare(this.number, s.number);
        if (result == 0) {
            result = Integer.compare(this.type, s.type);
        }
        return result;
    }
}