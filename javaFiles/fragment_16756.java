/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Deque<Interval> stack = new ArrayDeque<Interval>();

        Collections.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval p1, Interval p2) {
                    return Integer.compare(p1.start, p2.start);
                }
            }
        );

        if (intervals.size() < 1) {
            return intervals;
        }
        stack.push(intervals.get(0));

        for (int j = 1; j < intervals.size(); j++) {
            Interval i = intervals.get(j);
            Interval top  = stack.peek();
            if (top.end < i. start) {
                stack.push(i);
            }
            else if (top.end < i.end) {
                top.end = i.end;
            }
        }
        return new ArrayList<Interval>(stack);

    }
}