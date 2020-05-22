public static <T> void addandDisp(Collection<T> cs, T t) {
    cs.add(t);
}
...
List<? extends Object> ls2 = new LinkedList<Number>();
addandDisp(ls2, new Object());