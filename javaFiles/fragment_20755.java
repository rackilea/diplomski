private class Horse implements Comparable<Horse> {
    private String name;

    @Override
    public int compareTo(Horse o) {
        return o.name.compareTo(name);
    }
}