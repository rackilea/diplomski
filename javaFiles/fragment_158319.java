/** Checks whether two intervals overlap. */
boolean overlap(long startTime1, long endTime1, long startTime2, long endTime2) {
    if (endTime1 < startTime2 || startTime1 > endTime2) {
        return false;
    return true;
}