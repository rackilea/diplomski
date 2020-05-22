package com.stackoverflow.so21002436;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class App {
    public static void main(final String[] args)
    {
        final DateTime firstSeen = DateTime.now();
        final DateTime lastSeen = firstSeen.plusDays(8).plusMinutes(10).plusSeconds(45);

        final Period period = new Period(firstSeen, lastSeen);
        System.err.println(period); // P1W1DT10M45S, ie. 1 day, 10 minutes and 45 seconds

        final PeriodFormatter daysHoursMinutesSeconds = new PeriodFormatterBuilder().appendDays()
                .appendSuffix(" day", " days")
                .appendSeparator(", ")
                .appendMinutes()
                .appendSuffix(" minute", " minutes")
                .appendSeparator(" and ")
                .appendSeconds()
                .appendSuffix(" second", " seconds")
                .toFormatter();

        final String periodFormatted = daysHoursMinutesSeconds.print(period);
        System.out.println(periodFormatted);
    }
}