Comparator<SomeClass> comparator = new Comparator<SomeClass>() {
    @Override
    public int compare(final SomeClass o1, final SomeClass o2) {
        // Do some kind of compare-operation. If SomeField is 
        // Comparable you can do it this way:
        return o1.getSomeField().compareTo(o2.getSomeField());
    }
}