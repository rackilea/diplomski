public class SortPairs {

    static class Pair {
        final int foo;
        final int bar;

        Pair(int foo, int bar) {
            this.foo = foo;
            this.bar = bar;
        }

        @Override
        public String toString() {
            return "Pair{" + "foo=" + foo + ", bar=" + bar + '}';
        }
    }

    public static void main(String[] args) {

        List<Pair> pairs = Arrays.asList(
                new Pair(3, 1),
                new Pair(4, 2),
                new Pair(2, 3),
                new Pair(1, 4),
                new Pair(5, 5));

        System.out.println(pairs);

        Collections.sort(pairs, (pair1, pair2) -> pair1.foo - pair2.foo);
        System.out.println(pairs);
    }
}