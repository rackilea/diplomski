public static void main(String[] args) {
    Solution solution = new Solution();
    List<Interval> intervals = new ArrayList<>(); //Create list of intervals
    intervals.add(new Interval(1, 3));
    intervals.add(new Interval(6, 9));
    List<Interval> mergedIntervals = solution.insert(intervals, new Interval(2, 5));
    System.out.println(mergedIntervals);
}