import java.util.GregorianCalendar;

class DateTime2 {
    public int day, month, year;
    GregorianCalendar date = new GregorianCalendar();

    public DateTime2() {
        day = date.get(GregorianCalendar.DAY_OF_MONTH);
        month = date.get(GregorianCalendar.MONTH) + 1;
        year = date.get(GregorianCalendar.YEAR);
    }
    public DateTime2(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public String toString(){
        return month + "/" + day + "/" + year;
    }
}