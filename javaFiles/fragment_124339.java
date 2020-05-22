import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IntervalsTest {


    @Test
    public void shouldReturn1() {
        Intervals intervals = new Intervals();

        intervals.add(1, 10, 100);
        intervals.add(2, 200, 500);

        int result = intervals.findInterval(15);

        assertThat(result, is(1));

    }

    @Test
    public void shouldReturn2() {
        Intervals intervals = new Intervals();

        intervals.add(1, 10, 100);
        intervals.add(2, 200, 500);

        int result = intervals.findInterval(201);

        assertThat(result, is(2));

    }
}

class Range {

    private final int value;

    private final int lowerBound;

    private final int upperBound;


    Range(int value, int lowerBound, int upperBound) {
        this.value = value;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    boolean includes(int givenValue) {
        return givenValue >= lowerBound && givenValue <= upperBound;

    }

    public int getValue() {
        return value;
    }
}

class Intervals {

    public List<Range> ranges = new ArrayList<Range>();

    void add(int value, int lowerBound, int upperBound) {
        add(new Range(value, lowerBound, upperBound));
    }

    void add(Range range) {
        this.ranges.add(range);
    }

    int findInterval(int givenValue) {
        for (Range range : ranges) {
            if(range.includes(givenValue)){
                return range.getValue();
            }
        }

        return 0; // nothing found // or exception
    }
}