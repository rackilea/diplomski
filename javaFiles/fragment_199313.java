Arrays.sort(enums, new Comparator<Rank>>() {
    @Override
    public int compare(Rank o1, Rank o2) {
        if (o1 == o2) {
            return 0;
        }

        // Put NULL to the end.
        if (o1 == null) {
            return 1;
        }
        if (o2 == null) {
            return -1;
        }

        return o1.compareTo(o2); // sort by ordinal
    }
});