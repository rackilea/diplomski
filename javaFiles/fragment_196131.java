public class A {
    public static class NameComparator implements Comparator<A> {
        @Override
        public int compare(A o1, A o2) {
        return o1.name.compareToIgnoreCase(o2.name);
        }
    }
    ...
}