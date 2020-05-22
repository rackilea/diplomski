CollectionUtils.filter(myList, new Predicate<MyObject>() {
    @Override
    public boolean evaluate(MyObject o) {
        return o.getValue() >= 1 && o.getValue() <= 5;
    }
});