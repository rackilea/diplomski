package jool.features.analysis.tuple;

import org.jooq.lambda.tuple.Range;
import org.jooq.lambda.tuple.Tuple;

public class RangeTest {

    public static void main(String[] args) {

        Range<Integer> range = new Range<>(20,30);
        Range<Integer> range2 = new Range<>(Tuple.tuple(20,30));

        System.out.println(range.overlaps(22,40)); // returns true as 22 falls between 20 & 30.

    }
}