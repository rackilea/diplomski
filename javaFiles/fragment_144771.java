Collections.sort(list, new Comparator<String>() {
    @Override
    public int compare(String left, String right) {
        return Integer.compare(counts.get(left), counts.get(right));
    }
});