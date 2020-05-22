String time = "07:02";

long min = Integer.parseInt(time.substring(0, 2));
long sec = Integer.parseInt(time.substring(3));

long t = (min * 60L) + sec;

long result = TimeUnit.SECONDS.toMillis(t);