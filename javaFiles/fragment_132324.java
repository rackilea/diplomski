Arrays.sort(data, new Comparator<String[]>() {
    @Override
    public int compare(final String[] entry1, final String[] entry2) {
        final Integer time1 = Integer.valueOf(entry1[0]);
        final Integer time2 = Integer.valueOf(entry2[0]);
        return time1.compareTo(time2);
    }
});