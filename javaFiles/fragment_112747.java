private static boolean myEquals(Set o1, Set o2) {
    if (o1.size() == 1 && o2.size() == 1) {
        Iterator ic = o2.iterator();
        Iterator id = o1.iterator();

        while (ic.hasNext() && id.hasNext()) {
            if (!ic.next().equals(id.next())) {
                return false;
            }
        }
        return true;
    }
    return o1.equals(o2);
}

public static void main(String[] args) {
    print(skiplist(new BigDecimal("1.0")), tree(new BigDecimal("1.00")));
    print(skiplist(new BigDecimal("1.0")), hash(new BigDecimal("1.00")));
    print(skiplist(new BigDecimal("1.0")), identity(new BigDecimal("1.00")));
    print(skiplist(BigDecimal.ONE), identity(new BigDecimal(BigInteger.ONE, 0)));
}

private static Collection<BigDecimal> e() {
    return Arrays.asList(new BigDecimal("1.0"));
}

private static <E> Set<E> hash(E... e) {
    return new HashSet<>(Arrays.asList(e));
}

private static <E> Set<E> skiplist(E... e) {
    return new ConcurrentSkipListSet<>(Arrays.asList(e));
}

private static <E> Set<E> tree(E... e) {
    return new TreeSet<>(Arrays.asList(e));
}

private static <E> Set<E> identity(E... e) {
    Set<E> s = Collections.newSetFromMap(new IdentityHashMap<E, Boolean>());
    Collections.addAll(s, e);
    return s;
}

private static void print(Set o1, Set o2) {
    System.out.println(o1.getClass().getName()
            + "==" + o2.getClass().getName() + ": "
            + o1.equals(o2) + ": " + myEquals(o1, o2));
    System.out.println(o2.getClass().getName()
            + "==" + o1.getClass().getName() + ": " + o2.equals(o1)
            + ": " + myEquals(o2, o1));
}