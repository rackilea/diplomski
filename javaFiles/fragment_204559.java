List<Foo> getFoos() {
    return Lists.newArrayList(Iterables.filter(bases, Foo.class));
}

List<Bar> getBars() {
    return Lists.newArrayList(Iterables.filter(bases, Bar.class));
}