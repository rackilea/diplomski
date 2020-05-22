public class TupleAComparator<A extends Comparable<A>,B extends Comparable<B>> implements Comparator<Tuple<A,B>> {

    @Override
    public int compare(Tuple<A, B> t1, Tuple<A, B> t2) {
        return t1.aValue.compareTo(t2.aValue);
    }

}