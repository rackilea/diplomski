/**
 * A simple class for storing dates and times.
 * There is no support for time zones, leap years, etc.
 * So only use this when you're certain the dates and times you're storing are generated with special cases in mind.
 * @author Simon
 *
 */
public class SimpleDateTime 
{
    int year;
    int month;
    int day;
    int hour;
    int minute; 


    /**
     * Construct a simple date and time object
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     */
    public SimpleDateTime(int year, int month, int day, int hour, int minute) {
        super();
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Construct a simple date object, with time component initialised to 0
     * @param year
     * @param month
     * @param day
     */
    public SimpleDateTime(int year, int month, int day) {
        super();
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = 0;
        this.minute = 0;
    }

    /**
     * Construct a simple time object, with date component initialised to 0
     * @param hour
     * @param minute
     */
    public SimpleDateTime(int hour, int minute)
    {
        super();
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.hour = hour;
        this.minute = minute;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }   

    public String toDateString()
    {
        return day + "/" + month + "/" + year;
    }

    public String toTimeString()
    {
        return hour + ":" + minute;
    }

    /**
    * Parses a date from a string to a {@link SimpleDateTime} object.
    * Can handle various delimiters, as in these examples:
    * <ul>
    * <li>15/10/1993</li>
    * <li>15-10-1993</li>
    * <li>15.10.1993</li>
    * </ul>
    * It can also handle mixed delimiters as in these examples:
    * <ul>
    * <li>15/10.1993</li>
    * <li>15-10/1993</li>
    * <li>15.10-1993</li>
    * <li>etc.</li>
    * </ul>
    * @param date the string to parse
    * @return
    */
    public SimpleDateTime parseDate(String date)
    {
        String[] dateParts = date.split("[-\\.:]");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);

        return new SimpleDateTime(year, month, day);
    }




    /**
    * Parses a time from a string to a {@link SimpleDateTime} object.
    * Can handle various delimiters, as in these examples:
    * <ul>
    * <li>20.07</li>
    * <li>20:07</li>
    * <li>20-07</li>
    * </ul>
    * @param time the string to parse
    * @return
    */
    public SimpleDateTime parseTime(String time)
    {
        String[] timeParts = time.split("[-\\.:]");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);

        return new SimpleDateTime(hours, minutes);
    }
}