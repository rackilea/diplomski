Collections.sort(apps, new Comparator<AppDetail>() {

    /* This comparator will sort AppDetail objects alphabetically. */

    @Override
    public int compare(AppDetail a1, AppDetail a2) {

        // String implements Comparable
        return (a1.label.toString()).compareTo(a2.label.toString());
    }
});