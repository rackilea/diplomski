public static class Bar {
    public static class Beer { /* ... */ }
    public static class Wine { /* ... */ }
    private Set<Beer> beers = new HashSet<Beer>();
    private Set<Wine> wines = new HashSet<Wine>();

    public Iterable<Beer> beerIterable() { return Collections.unmodifiableSet(beers); }
    public Iterable<Wine> wineIterable() { return Collections.unmodifiableSet(wines); }
}

public static void main(String[] args) {
    for (Bar.Beer beer : new Bar().beerIterable()) {

    }
}