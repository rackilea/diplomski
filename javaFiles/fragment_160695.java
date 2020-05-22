public static List flatten(List flatten, Set<Integer> ignore) {
    List result = new LinkedList();
    ignore.add(System.identityHashCode(flatten));
    for (Object o : flatten) {
        if (o instanceof List) {
            if (! ignore.contains(System.identityHashCode(o))) {
                result.addAll(flatten((List) o, ignore));
            }
        } else {
            result.add(o);
        }
    }
    return result;
}