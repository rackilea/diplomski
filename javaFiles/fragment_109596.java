public static <P extends Product<?>, C> TreeMap<P, C> insertIntoMap(
        LinkedHashSet<P> set, C[] ac) {

    TreeMap<P, C> treeMap = new TreeMap<P, C>(new myComperator());

    int itrIndex = 0;
    Iterator<P> itr = set.iterator();

    while (itr.hasNext()) {
        treeMap.put(itr.next(), ac[itrIndex]);
        itrIndex++;
    }

    return treeMap;
}