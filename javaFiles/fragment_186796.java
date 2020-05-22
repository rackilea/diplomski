class Interval {
    double begin, end;
}

class BeginComparator implements java.util.Comparator<Interval> {
    public int compare(Interval o1, Interval o2) {
        return Double.compare(o1.begin, o2.begin);
    }
};

public class IntervalTree {
    IntervalTree(Interval[] intervals_) {
        intervals = intervals_.clone();
        java.util.Arrays.sort(intervals, new BeginComparator());
        maxEnd = new double[intervals.length];
        initializeMaxEnd(0, intervals.length);
    }

    double initializeMaxEnd(int a, int b) {
        if (a >= b) {
            return Double.NEGATIVE_INFINITY;
        }
        int m = (a + b) >>> 1;
        maxEnd[m] = initializeMaxEnd(a, m);
        return Math.max(Math.max(maxEnd[m], intervals[m].end), initializeMaxEnd(m + 1, b));
    }

    void findContainingIntervals(double x, int a, int b, java.util.Collection<Interval> result) {
        if (a >= b) {
            return;
        }
        int m = (a + b) >>> 1;
        Interval i = intervals[m];
        if (x < i.begin) {
            findContainingIntervals(x, a, m, result);
        } else {
            if (x <= i.end) {
                result.add(i);
            }
            if (maxEnd[m] >= x) {
                findContainingIntervals(x, a, m, result);
            }
            findContainingIntervals(x, m + 1, b, result);
        }
    }

    java.util.Collection<Interval> findContainingIntervals(double x) {
        java.util.Collection<Interval> result  = new java.util.ArrayList<Interval>();
        findContainingIntervals(x, 0, intervals.length, result);
        return result;
    }

    Interval[] intervals;
    double[] maxEnd;

    public static void main(String[] args) {
        java.util.Random r = new java.util.Random();
        Interval[] intervals = new Interval[10000];
        for (int j = 0; j < intervals.length; j++) {
            Interval i = new Interval();
            do {
                i.begin = r.nextDouble();
                i.end = r.nextDouble();
            } while (i.begin >= i.end);
            intervals[j] = i;
        }
        IntervalTree it = new IntervalTree(intervals);
        double x = r.nextDouble();
        java.util.Collection<Interval> result = it.findContainingIntervals(x);
        int count = 0;
        for (Interval i : intervals) {
            if (i.begin <= x && x <= i.end) {
                count++;
            }
        }
        System.out.println(result.size());
        System.out.println(count);
    }
}