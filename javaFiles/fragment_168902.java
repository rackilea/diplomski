long totalSeconds = 0L;
for (Date date : dates) {
     totalSeconds += date.getTime() / 1000L;
}
long averageSeconds = totalSeconds / dates.size();
Date averageDate = new Date(averageSeconds * 1000L);