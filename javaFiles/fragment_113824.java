Collection<POJO> subList = CollectionUtils.subtract(p1, p2, new Predicate<POJO>() {
    @Override
    public boolean evaluate(POJO object) {
        return p1.contains(object); // might need to make p1 final
    }
});