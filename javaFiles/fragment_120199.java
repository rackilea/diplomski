List<IntRange> ranges = new ArrayList<IntRange>() {{
    add(new IntRange(0, 2));
    add(new IntRange(2, 6));
    add(new IntRange(6, 0));
}};

public boolean inRange(int n, List<IntRange> ranges) {
    for (IntRange range : ranges) {
        if (range.containsInteger(n)) {
            return true;
        }
    }
    return false;
}