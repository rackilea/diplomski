import org.jooq.lambda.tuple.Range;
import org.jooq.lambda.tuple.Tuple;

public class RangeTest {

    public static void main(String[] args) {

        Range<Integer> range = new Range<>(20,30);
        Range<Integer> range2 = new Range<>(Tuple.tuple(20,30));

        System.out.println(range.intersection(22,40)); // returns Range(22,30) 

    }
}