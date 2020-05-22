public static void main(String[] args) {
    final double t = 1304.00d;

    if (t > 1440.00d) //possible loss of precision again
        return;

    int hours = (int)t / 60;
    int minutes = (int)t % 60;
    BigDecimal secondsPrecision = new BigDecimal((t - Math.floor(t)) * 100).setScale(2, RoundingMode.HALF_UP);
    int seconds = secondsPrecision.intValue();

    boolean nextDay = false;

    if (seconds > 59) {
        minutes++; //increment minutes by one
        seconds = seconds - 60; //recalculate seconds
    }

    if (minutes > 59) {
        hours++;
        minutes = minutes - 60;
    }

    //next day
    if (hours > 23) {
        hours = hours - 24;
        nextDay = true;
    }

    //if seconds >=10 use the same format as before else pad one zero before the seconds
    final String myFormat = seconds >= 10 ? "%d:%02d:%d" : "%d:%02d:0%d";
    final String time = String.format(myFormat, hours, minutes, seconds);
    System.out.print(time);
    System.out.println(" " + (nextDay ? "The next day" : "Current day"));
}