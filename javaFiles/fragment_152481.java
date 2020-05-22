Predicate<Boolean> test2 = new Predicate<Boolean>() {
    @Override
    public boolean test(Boolean p) {
        return p; // since 'p == true' would effectively be 'p'
    }
};