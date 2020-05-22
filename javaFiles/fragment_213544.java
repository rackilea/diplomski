public int compareTo(Object o) {
    Match m = (Match)o;
    int diff = m.matches - matches;
    if (diff == 0) {
        return Double.compare(distance, m.distance);
    } else {
        return diff;
    }
}