Entry findAfter(TreeMap map, Key key, Predicate p) {
    for (Entry e : map.tailMap().entrySet()) {
        if (p.test(e.getValue() && 
            !e.getKey().equals(key))
             return e;
    }
    return null;
}