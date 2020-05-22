public long compareTwoTimeStamps(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime) 
{
    long min1 = oldTime.getHours() * 60 + oldTime.getMinutes();
    long min2 = currentTime.getHours() * 60 + currentTime.getMinutes();
    return min2 - min1;
}