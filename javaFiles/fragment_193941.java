@Grab(group='joda-time', module='joda-time', version='2.0')

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import java.util.TimeZone;


def value = '2016-12-31T13:14:15+02';

String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
DateTime dateTime = dtf.parseDateTime(value);

TimeZone tz = TimeZone.getTimeZone("CET");
def result = dateTime.withZone( DateTimeZone.forTimeZone(tz) ).toString();