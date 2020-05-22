Arrays.sort(points, new Comparator<Segment>() {
    @Override
    public int compare(Segment s1, Segment s2) {
        int result = Integer.compare(s1.number, s2.number);
        if (result == 0) {
            result = Integer.compare(s1.type, s2.type);
        }
        return result;
    }
});