class Range {
    private long start;
    private long end;

    Range(String start, String end) {
        this.start = Long.parseLong(start);
        this.end = Long.parseLong(end);
    }

    Range(String range) {
        this(range.split("-")[0], range.split("-")[1]);
    }

    boolean inRange(long n) {
        returns start <= n && n <= end;
    }
}