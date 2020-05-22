public List<String> getStrings(Supplier<List<String>> listSupplier) {
    List<String> tmp = listSupplier.get();
    tmp.add("foo");
    return tmp;
}

public void caller() {
    List<String> stringList = getStrings(LinkedList::new);
}