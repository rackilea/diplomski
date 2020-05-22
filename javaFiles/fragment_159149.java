Collections.sort(temp, new Comparator<SMS>() {
    @Override
    public int compare(SMS o1, SMS o2) {
        return Long.compare(o1.timestamp, o2.timestamp);
    }
});