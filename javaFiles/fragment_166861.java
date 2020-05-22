final String x = someObject.getStringValue();
Predicate<String> p = new Predicate<String>() {
    @Override
    public boolean test(String t) {
        return x.equalsIgnoreCase(t);
    }
}
Stream.of("A", "B", "C").anyMatch(p)