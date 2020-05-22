public static <P> void rearrange(Set<P> set) {
    HashSet<P> temp = new HashSet<P>();
    temp.addAll(set);
    set.clear();
    set.addAll(temp);
}