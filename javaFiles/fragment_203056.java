public static String getTimeAgo(long time) {

    final DateFormat sdfTime = new SimpleDateFormat("h:mm aa", Locale.ENGLISH);
    final DateFormat sdf = new SimpleDateFormat("d MMM 'at' h:mm aa", Locale.ENGLISH);
    final DateFormat sdfY = new SimpleDateFormat("d MMM yyyy 'at' h:mm aa", Locale.ENGLISH);

    final int SECOND_MILLIS = 1000;
    final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    final int DAY_MILLIS = 24 * HOUR_MILLIS;

    if (time < 1000000000000L) {
        time *= 1000;
    }

    Calendar today = Calendar.getInstance();

    Calendar timeCal = Calendar.getInstance();
    timeCal.setTimeInMillis(time);

    long now = System.currentTimeMillis();
    if (time > now || time <= 0) {
        return null;
    }

    final long diff = now - time;
    if (diff < MINUTE_MILLIS) {
        return "Just now";
    } else if (diff < 2 * MINUTE_MILLIS) {
        return "1 min";
    } else if (diff < 59 * MINUTE_MILLIS) {
        return diff / MINUTE_MILLIS + " mins";
    } else if (diff < 2 * HOUR_MILLIS) {
        return "1 hr";
    } else if (diff < 24 * HOUR_MILLIS) {
        return diff / HOUR_MILLIS + " hrs";
    } else if (diff < 48 * HOUR_MILLIS) {
        return ("Yesterday at " + capsAMtoSmall(sdfTime.format(timeCal.getTime())));
    } else if (today.get(Calendar.YEAR) == timeCal.get(Calendar.YEAR)) {
        return capsAMtoSmall(sdf.format(timeCal.getTime()));
    } else {
        return capsAMtoSmall(sdfY.format(timeCal.getTime()));
    }
}