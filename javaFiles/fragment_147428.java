import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

String time22 = "22:02:50";
String timeInTheList = "21:19:46";

// create formatter with format hour:minute:second
DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm:ss");

// parse Strings
LocalTime sTime2 = fmt.parseLocalTime(time22);
LocalTime fTime1 = fmt.parseLocalTime(timeInTheList);

// get the minutes between them
int minutes = Minutes.minutesBetween(fTime1, sTime2).getMinutes();
System.out.println(minutes); // 43