/**
 *  Utility method that parses java.util.Date to java 8's java.time.LocalDat
 * <p>
 * TODO finish method design
 *
 * @param calendarObj
 * @return
 */
public static LocalDate parseCalendarToLocalDate(Calendar calendarObj) {

    int month = calendarObj.get(Calendar.MONTH);
    int year = calendarObj.get(Calendar.YEAR);
    int day = calendarObj.get(Calendar.DAY_OF_MONTH);

    LocalDate localDateObj =  LocalDate.of(year,(month+1),day);
    return localDateObj;
}