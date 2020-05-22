Collections.sort(data, new Comparator<Segment>() {
    @Override
    public int compare(Segment lhs, Segment rhs) {
        return Integer.compare(lhs.getR(), rhs.getR());
    }
});