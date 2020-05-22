import java.util.Comparator;


public class StringIntTupleIntComparator implements Comparator<StringIntTuple> {

    @Override
    public int compare(StringIntTuple a,
            StringIntTuple b) {
        return ((Integer)a.intValue).compareTo((Integer)b.intValue);
    }

}