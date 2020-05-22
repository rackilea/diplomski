// 96-minutes duration
Duration duration = new Duration(96 * 60 * 1000);
long secs = duration.toStandardSeconds().getSeconds();
if (secs >= 3600) { // more than 1 hour
    BigDecimal secondsPerHour = new BigDecimal(3600);
    int hours = new BigDecimal(secs).divide(secondsPerHour, RoundingMode.HALF_DOWN).intValue();

    System.out.println(hours + " hour" + (hours > 1 ? "s" : "")); // 2 hours
} else {
    int mins;
    if (secs == 0) { // round zero seconds to 1 minute
        mins = 1;
    } else {
        // always round up (1-59 seconds = 1 minute)
        BigDecimal secondsPerMin = new BigDecimal(60);
        mins = new BigDecimal(secs).divide(secondsPerMin, RoundingMode.UP).intValue();
    }
    System.out.println(mins + " minute" + (mins > 1 ? "s" : ""));
}