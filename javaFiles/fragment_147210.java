Collections.sort(listOfHills, new Comparator<Hill>() {
    @Override
    public int compare(Hill o1, Hill o2) {
        return o2.height > o1.height ? (o2.height == o1.height ? 0 : 1) : -1;
    }
});