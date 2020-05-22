public static Date getCurrentTimeOnly() {

    Date time = new Date();

    time.setTime(time.getTime() % (24 * 60 * 60 * 1000));

    return time;
}