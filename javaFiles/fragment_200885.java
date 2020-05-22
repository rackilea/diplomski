public List<String> concat(final List<String> list1, final List<String> list2) {
    final Iterator<String> i1 = list1.iterator();
    final Iterator<String> i2 = list2.iterator();

    final List<String> combined = new ArrayList<>();
    while (i1.hasNext() && i2.hasNext()) {
        combined.add(i1.next() + i2.next());
    }
    return combined;
}