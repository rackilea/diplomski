package org.devmaster.sample;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.Calendar;
import java.util.Date;

public final class Util {

    public static boolean compareHrsAndMintsOnly(Date startSH, Date now, Date stopSH) {
        DateTime start = toDateTime(startSH);
        DateTime end = toDateTime(stopSH);

        Interval interval = new Interval(start, end);

        DateTime instant = toDateTime(now);

        // now is between startSH and stopSH
        return interval.contains(instant);
    }

    private static DateTime toDateTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return new DateTime(
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH),
                c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE));
    }

}