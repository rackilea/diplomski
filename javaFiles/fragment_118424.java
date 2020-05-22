Predicate<String> somePredicate = new Predicate<String>() {
    @Override
    public boolean test(String string) {
        return !string.isEmpty();
    }
};