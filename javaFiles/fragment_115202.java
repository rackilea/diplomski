class ColorCounter implements Comparable<ColorCounter> {
    RGB rgb;
    int count;

    public int compareTo(ColorCounter o) {
        return o.count - count;
    }
}