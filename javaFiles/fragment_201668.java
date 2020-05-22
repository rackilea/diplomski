import java.util.Comparator;


public class StringIntTupleStringComparator implements
        Comparator<StringIntTuple> {

    @Override
    public int compare(StringIntTuple a, StringIntTuple b) {
        // TODO Auto-generated method stub
        return a.stringValue.compareTo(b.stringValue);
    }

}