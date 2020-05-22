static int compareLengthLowTag(Match a, Match b) {
    int aLength = a.interval.getHigh() - a.interval.getLow();
    int bLength = b.interval.getHigh() - b.interval.getLow();
    int compare = - Integer.compare(aLength, bLength);
    if (compare == 0)
        compare = a.interval.getLow().compareTo(b.interval.getLow());
    if (compare == 0)
        compare = a.tag.compareTo(b.tag);
    return compare;
}