package so38810914;

import java.time.LocalTime;
import static java.util.Objects.*;

public class Question {

    public static class LocalTimeRange {

        private final LocalTime from;
        private final LocalTime to;

        public LocalTimeRange(LocalTime from, LocalTime to) {
            requireNonNull(from, "from must not be null");
            requireNonNull(to, "to must not be null");
            this.from = from;
            this.to = to;
        }

        public boolean overlaps(LocalTimeRange other) {
            requireNonNull(other, "other must not be null");
            return isBetween(other.from, this.from, this.to)
                    || isBetween(other.to, this.from, this.to)
                    || isBetween(this.from, other.from, other.to)
                    || isBetween(this.to, other.from, other.to);
        }

        private static boolean isBetween(LocalTime t, LocalTime from, LocalTime to) {
            if (from.isBefore(to)) { // same day
                return from.isBefore(t) && t.isBefore(to);
            } else { // spans to the next day.
                return from.isBefore(t) || t.isBefore(to);
            }
        }
    }

    public static void main(String[] args) {
        test( 0,  1,     2,  3,    false);
        test( 2,  3,     0,  1,    false);
        test( 0,  3,     1,  2,    true);
        test( 1,  2,     0,  3,    true);
        test( 0,  2,     1,  3,    true);
        test(12, 18,    15, 21,    true);
        test(18,  6,    21,  3,    true);
        test(21,  3,     0,  6,    true);
        test(21,  0,     3,  6,    false);

    }

    private static void test(int from1, int to1, int from2, int to2, boolean overlap) {
        LocalTimeRange range1 = new LocalTimeRange(LocalTime.of(from1, 0), LocalTime.of(to1, 0));
        LocalTimeRange range2 = new LocalTimeRange(LocalTime.of(from2, 0), LocalTime.of(to2, 0));
        boolean test = (range1.overlaps(range2)) == overlap;
        System.out.printf("[%2d-%2d] - [%2d-%2d] -> %-5b: %s%n", from1, to1, from2, to2, overlap, test?"OK":"Not OK");
    }
}