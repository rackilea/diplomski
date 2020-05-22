public class CalendarDateWithoutTimeComparator implements Comparator<Calendar> {

    public int compare(Calendar cal1, Calendar cal2) {
        if(cal1.get(Calendar.YEAR) != cal2.get(Calendar.YEAR)) {
            return cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        } else if (cal1.get(Calendar.MONTH) != cal2.get(Calendar.MONTH)) {
            return cal1.get(Calendar.MONTH) - cal2.get(Calendar.MONTH);
        }
        return cal1.get(Calendar.DAY_OF_MONTH) - cal2.get(Calendar.DAY_OF_MONTH);
    }
}