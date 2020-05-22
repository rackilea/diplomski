final SortedMap<Project, List<Activity>> map = new TreeMap<>(new Comparator<Project>() {
    @Override
    public int compare(final Project p1, final Project p2) {
        final int c = Integer.valueOf(p1.unit.id).compareTo(Integer.valueOf(p2.unit.id));
        if (c != 0) {
           return c;
        }
        return p1.id.compareTo(p2.id);
    }
});