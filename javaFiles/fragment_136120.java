public List<Emp> removeDuplicate(final List<Emp> items) {
    final List<Emp> result = new ArrayList<Emp>();
    final List<Emp> doublettes = new ArrayList<Emp>();
    for(final Emp item : items) {
        if (!doublettes.contains(item) {
            result.add(item);
            doublettes.add(item);
        }
    }
    return result;
}