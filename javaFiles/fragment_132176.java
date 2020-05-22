public class DateRange {
    private final Object obj1;
    private final Object obj2;
    public DateRange(Date date1, Date date2) {
        obj1 = date1;
        obj2 = date2;
    }
    public DateRange(String string1, String string2) {
        obj1 = string1;
        obj2 = string2;
    }
    public DateRange(int month, int year) {
        obj1 = Integer.valueOf(month);
        obj2 = Integer.valueOf(year);
    }
    public boolean isDate() { return obj1 instanceof Date; }
    public boolean isString() { return obj1 instanceof String; }
    public boolean isInt() { return obj1 instanceof Integer; }
}