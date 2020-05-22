public static final long MILLISECONDS_PER_DAY = 24 * 60 * 60 * 1000;// In real app you should pre-calculate this value
public static final String RECENT_DATE_FORMAT = "HH:mm";
public static final String OLD_DATE_FORMAT = "E' at 'HH:mm";

public static String displayTime(long timestamp) {
  long current = System.getCurrentTimeMillis();
  long last24hTimestamp = current - MILLISECONDS_PER_DAY;

  if (timestamp > last24hTimestamp) {

   // Received message within a day, use first format
   SimpleDateFormat sdf = new SimpleDateFormat(RECENT_DATE_FORMAT);
   return sdf.format(new Date(timestamp));
  } else {
    // Message is older than 1 day. Use second format

  }

}