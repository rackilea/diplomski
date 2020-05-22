// if you're using ThreeTen Backport, replace java.time by org.threeten.bp
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

String time22 = "22:02:50";
String timeInTheList = "21:19:46";

// parse Strings
LocalTime sTime2 = LocalTime.parse(time22);
LocalTime fTime1 = LocalTime.parse(timeInTheList);

// get the minutes between them
long minutes = ChronoUnit.MINUTES.between(fTime1, sTime2);
System.out.println(minutes); // 43