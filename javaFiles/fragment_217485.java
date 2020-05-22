public static long getSecondsDifference(Timestamp timeStamp) {
    final Calendar calendar = Calendar.getInstance(Locale.getDefault());

    int offset = TimeZone.getDefault().getOffset(timeStamp.getTime());

    if (TimeZone.getDefault().inDaylightTime(Calendar.getInstance().getTime())) {
        offset = offset - TimeZone.getDefault().getDSTSavings();
    }
    final long referenceSeconds = (timeStamp.getTime() + offset) / 1000;

    final long currentTimeSeconds = (calendar.getTimeInMillis()) / 1000;

    final long differenceSeconds = (currentTimeSeconds - referenceSeconds);

    return differenceSeconds;
}