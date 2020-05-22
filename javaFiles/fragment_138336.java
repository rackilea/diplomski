// © 2013 Basil Bourque. This source code may be used freely forevery by anyone taking full responsibility for doing so.

// Joda-Time - The popular alternative to Sun/Oracle's notoriously bad date, time, and calendar classes bundled with Java 7 and earlier.
// http://www.joda.org/joda-time/

// Joda-Time will become outmoded by the JSR 310 Date and Time API introduced in Java 8.
// JSR 310 was inspired by Joda-Time but is not directly based on it.
// http://jcp.org/en/jsr/detail?id=310

// By default, Joda-Time produces strings in the standard ISO 8601 format.
// https://en.wikipedia.org/wiki/ISO_8601

// Time Zone list: http://joda-time.sourceforge.net/timezones.html
org.joda.time.DateTimeZone seattleTimeZone = org.joda.time.DateTimeZone.forID("America/Los_Angeles");
org.joda.time.DateTimeZone icelandTimeZone = org.joda.time.DateTimeZone.forID("Atlantic/Reykjavik");

// Switch between using 'seattleTimeZone' and 'icelandTimeZone' to see different results (23 vs 24).
org.joda.time.DateTime theNinth = new org.joda.time.DateTime( 2014, 3, 9, 0, 0, seattleTimeZone ) ; // Day when DST begins.
org.joda.time.DateTime theTenth = theNinth.plusDays( 1 ); // Day after DST begins.

// Using "hoursBetween()" method with a pair of DateTimes.
org.joda.time.Hours hoursObject = org.joda.time.Hours.hoursBetween( theNinth.withTimeAtStartOfDay(), theTenth.withTimeAtStartOfDay() );
int hoursInt = hoursObject.getHours();
System.out.println( "Expected 23 from hoursInt, got: " + hoursInt );

// Using an Interval.
org.joda.time.Interval interval = new Interval( theNinth.withTimeAtStartOfDay(), theTenth.withTimeAtStartOfDay() );
System.out.println( "Expected 23 from interval, got: " + org.joda.time.Hours.hoursIn(interval).getHours() );

// Using a Period with Standard days.
org.joda.time.Period period = new org.joda.time.Period( theNinth.withTimeAtStartOfDay(), theTenth.withTimeAtStartOfDay() );
org.joda.time.Hours standardHoursObject = period.toStandardHours();
System.out.println( "Expected 24 from standardHoursObject, got: " + standardHoursObject.getHours() );