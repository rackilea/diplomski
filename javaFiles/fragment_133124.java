static int compareLowLengthTag(Match a, Match b) {
    int compare = a.interval.getLow().compareTo(b.interval.getLow());
    if (compare == 0)
        compare = - a.interval.getHigh().compareTo(b.interval.getHigh());
    if (compare == 0)
        compare = a.tag.compareTo(b.tag);
    return compare;
}