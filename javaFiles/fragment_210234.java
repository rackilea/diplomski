public class DateTimeHelper {

    public static final String MYSQL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final TimeZone timeZoneUTC = TimeZone.getTimeZone("UTC");

    private Date date = new Date();
    private final SimpleDateFormat format;

    public DateTimeHelper(String dateTimeFormat) {
        format = new SimpleDateFormat(dateTimeFormat, Locale.US);
    }

    public DateTimeHelper(String dateTimeFormat, String utcTimeString) {
        this(dateTimeFormat);

        try {
            format.setTimeZone(timeZoneUTC);
            Date utc = format.parse(utcTimeString);
            format.setTimeZone(TimeZone.getDefault());
            String local = format.format(utc);
            date = format.parse(local);
        } catch (ParseException e) {
            // nothing
        }
    }

    public Date getDate() {
        return date;
    }

    public Date toUtc() {

        String temp = toString();
        format.setTimeZone(timeZoneUTC);
        try {
            return format.parse(temp);
        } catch (ParseException e) {
            return date;
        }
    }

    @Override
    public String toString() {
        format.setTimeZone(TimeZone.getDefault());
        return format.format(date);
    }

    public String toUtcString() {
        format.setTimeZone(timeZoneUTC);
        return format.format(date);
    }
}