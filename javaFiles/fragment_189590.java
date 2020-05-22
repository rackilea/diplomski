public static boolean overlaps(LocalTime begin1, LocalTime end1, LocalTime begin2, LocalTime end2) {
    if (begin1.equals(end1)) { // zero length, cannot overlap anything
        return false;
    }
    if (begin2.equals(end2)) {
        return false;
    }

    // If any interval is 12 hours or longer,
    // the other one is necessarily included, that is, overlaps
    if (is12HoursOrLonger(begin1, end1)) {
        return true;
    }
    if (is12HoursOrLonger(begin2, end2)) {
        return true;
    }

    // Convert all times to AM
    begin1 = toAm(begin1);
    end1 = toAm(end1);
    begin2 = toAm(begin2);
    end2 = toAm(end2);

    // For the two intervals *not* to overlap we must be able to go forward
    // from begin1 through end1 and begin2 to end2 in this order either
    // not crossing 12 or crossing 12 once and ending before or on begin1
    boolean crossed12OClock = false;
    if (end1.isBefore(begin1)) { // to go forward to end1 we are crossing 12 o’clock
        crossed12OClock = true;
    }
    if (begin2.isBefore(end1)) {
        if (crossed12OClock) {
            // crossing 12 for the second time;
            // intervals cannot be in non-overlapping order
            return true;
        }
        crossed12OClock = true;
    }
    if (end2.isBefore(begin2)) {
        if (crossed12OClock) {
            return true;
        }
        crossed12OClock = true;
    }
    if (crossed12OClock) {
        return end2.isAfter(begin1);
    } else {
        return false;
    }
}