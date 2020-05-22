class TestSortComparator implements Comparator<TestSort> {

    Double defaultIfNull(Double d) {
        return d == null ? Double.NEGATIVE_INFINITY : d;
    }

    Integer defaultIfNull(Integer i) {
        return i == null ? Integer.MIN_VALUE : i;
    }

    String defaultIfNull(String s) {
        return s == null ? "" : s;
    }

    @Override
    public int compare(TestSort o1, TestSort o2) {
        int pageComp = defaultIfNull(o1.getPage())
            .compareTo(defaultIfNull(o2.getPage()));
        if (pageComp != 0) return pageComp;
        int yComp = defaultIfNull(o1.getTopLeftY())
            .compareTo(defaultIfNull(o2.getTopLeftY()));
        if (yComp != 0) return yComp;
        int xComp = defaultIfNull(o1.getTopLeftX())
            .compareTo(defaultIfNull(o2.getTopLeftX()));
        if (xComp != 0) return xComp;
        return defaultIfNull(o1.getFormField())
            .compareTo(defaultIfNull(o2.getFormField()));
    }
}