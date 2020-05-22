class MiniFoodFreezer {

    private final Freezer freezer = new Freezer();

    public <T extends Freezeable & Edible & SmallerThanABeachball> void add(
            final T toStore
    ) {
        freezer.add(toStore);
    }

    public Iterable<Freezeable> asFreezables() {
        return freezer;
    }

    public Iterable<Edible> asEdibles() {
        // this is okay because add must take an Edible and Iterable is read-only
        @SuppressWarnings("unchecked")
        final Iterable<Edible> edibles = (Iterable<Edible>)(Iterable<?>)freezer;
        return edibles;
    }

    public Iterable<SmallerThanABeachball> asSmallerThanBeachballs() {
        // same reasoning as above
        @SuppressWarnings("unchecked")
        final Iterable<SmallerThanABeachball> smallerThanBeachballs =
                (Iterable<SmallerThanABeachball>)(Iterable<?>)freezer;
        return smallerThanBeachballs;
    }
}