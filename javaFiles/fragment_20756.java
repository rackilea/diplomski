Collections.sort(new ArrayList<Horse>(), new Comparator<Horse>() {
    @Override
    public int compare(Horse o1, Horse o2) {
        return o1.name.compareTo(o2.name);
    }
});