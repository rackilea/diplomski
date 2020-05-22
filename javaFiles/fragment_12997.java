private static String displayQuoteTime(long seconds) {

    int day = (int) TimeUnit.SECONDS.toDays(seconds);
    long hours = TimeUnit.SECONDS.toHours(seconds)

            - TimeUnit.DAYS.toHours(day);
    int months = day / 30;
    int years = months / 12;
    long minute = TimeUnit.SECONDS.toMinutes(seconds)
            - TimeUnit.DAYS.toMinutes(day)
            - TimeUnit.HOURS.toMinutes(hours);
    long second = TimeUnit.SECONDS.toSeconds(seconds)
            - TimeUnit.DAYS.toSeconds(day)
            - TimeUnit.HOURS.toSeconds(hours)
            - TimeUnit.MINUTES.toSeconds(minute);
    String postTime = "";
    if (years > 0) {
        if (TextUtils.isEmpty(postTime)) {
            if (years == 1) {
                postTime = years + " year";
            } else {
                postTime = years + " years";
            }

        } else {
            postTime = postTime + " " + years + " years";
        }
    }
        else if (months > 0) {
        if (TextUtils.isEmpty(postTime)) {
            if (months == 1) {
                postTime = months + " month";
            } else {
                postTime = months + " months";
            }
        } else
            postTime = postTime + " " + months + " months";
    } else if (day > 0) {
        if (day == 1) {
            postTime = day + " day";
        } else {
            postTime = day + " days";
        }
    } else if (hours > 0) {
        if (TextUtils.isEmpty(postTime)) {
            if (hours == 1) {
                postTime = hours + " hour";
            } else {
                postTime = hours + " hours";
            }

        } else {
            postTime = postTime + " " + hours + " hours";
        }

    } else if (minute > 0) {
        if (TextUtils.isEmpty(postTime)) {
            if (minute == 1) {
                postTime = minute + " min";
            } else {
                postTime = minute + " mins";
            }
        } else
            postTime = postTime + " " + minute + " mins";
    }else {
        if (TextUtils.isEmpty(postTime))
            postTime = "second";
    }
    postTime = postTime + " ago";

    System.out.println(" years " + years + " months " + months + " Day " + day + " Hour " + hours + " Minute "
            + minute + " Seconds " + second);
    return postTime;
}