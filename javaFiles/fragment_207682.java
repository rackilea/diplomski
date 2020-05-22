doSomething(() -> new Foo<List<? extends Object>>() {
    @Override
    public List<? extends Object> getBar() {
        return null;
    }
});