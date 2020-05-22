import java.util.GregorianCalendar;

class DateTime {
    private int day, month, year;
    GregorianCalendar date = new GregorianCalendar();

    public DateTime() {
        day = date.get(GregorianCalendar.DAY_OF_MONTH);
        month = date.get(GregorianCalendar.MONTH) + 1;
        year = date.get(GregorianCalendar.YEAR);
    }
    public DateTime(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Accessors ///
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }

    // Mutators ///
    public int setDay(){
        return day;
    }
    public int setMonth(){
        return month;
    }
    public int setYear(){
        return year;
    }

    // String ///
    public String toString(){
        return getMonth() + "/" + getDay() + "/" + getYear();
    }
}