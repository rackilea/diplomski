public boolean equals(Object obj) {
    if (this == obj)
        return true;
try {
    Calendar that = (Calendar)obj;
    return compareTo(getMillisOf(that)) == 0 &&
    lenient == that.lenient &&
    firstDayOfWeek == that.firstDayOfWeek &&
    minimalDaysInFirstWeek == that.minimalDaysInFirstWeek &&
    zone.equals(that.zone);
} catch (Exception e) {
    // Note: GregorianCalendar.computeTime throws
    // IllegalArgumentException if the ERA value is invalid
    // even it's in lenient mode.
}
return false;
}