public int compare(Request r1, Request r2) {
    int diff = Integer.compare(r1.getTimeStamp(), r2.getTimeStamp());

    if (diff != 0)
        return diff;

    return Integer.compare(r1.siteId(), r2.siteId());
}