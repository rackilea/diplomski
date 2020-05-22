public class MySqlDateTimeHelper extends DateTimeHelper {

    public MySqlDateTimeHelper() {
        super(DateTimeHelper.MYSQL_DATE_TIME_FORMAT);
    }

    public MySqlDateTimeHelper(String utcTimeString) {
        super(DateTimeHelper.MYSQL_DATE_TIME_FORMAT, utcTimeString);
    }

    public static String getCurrentTimestampUtc() {
        MySqlDateTimeHelper current = new MySqlDateTimeHelper();
        return current.toUtcString();
    }
}