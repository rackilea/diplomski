Collections.sort(list, new Comparator<Result>() {
    @Override
    public int compare(Result r1, Result r2) {
        return r1.getValue() - r2.getValue();
    }
});