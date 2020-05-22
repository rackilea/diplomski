public long compareTwoTimeStamps(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime)
{
    final Calendar oldCal = Calendar.getInstance();
    oldCal.setTime(oldTime);
    long min1 = oldCal.get(Calendar.HOUR) * 60 + oldCal.get(Calendar.MINUTE);
    final Calendar currentCal = Calendar.getInstance();
    oldCal.setTime(currentTime);
    long min2 = currentCal.get(Calendar.HOUR) * 60 + currentCal.get(Calendar.MINUTE);
    return min2 - min1;
}