long now = System.currentTimeMillis();
// time of the day in minutes.
long time = ((now + TimeZone.getDefault().getOffset(now)) % 86400000) / 60000;
if (time <  6*60 + 10) return "-S1";
if (time < 14*60 + 10) return "-S2";
if (time < 22*60) return "-S3";
return "-S1";