private static boolean isDateInRange(String start, String end, String date) {
    DynamicTemporal dateTemporal = DynamicTemporal.parse(date);
    DynamicTemporal startTemporal = DynamicTemporal.parse(start);
    DynamicTemporal endTemporal = DynamicTemporal.parse(end);
    if (startTemporal != null && dateTemporal.compareTo(startTemporal) < 0)
        return false; // date is before start
    if (endTemporal != null && dateTemporal.compareTo(endTemporal) > 0)
        return false; // date is after end
    return true;
}