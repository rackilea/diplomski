public enum IsNonEmpty implements Predicate<String> {
    INSTANCE;

    @Override
    public boolean test(String s) {
        return !s.isEmpty();
    }
}