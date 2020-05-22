public class DateV1 {

    protected final Date date;

    public DateV1(Date date) { 
        this.date = date;
    }

    public int getYear() {
        return 1900 + date.getYear();
    }
}

public class DateV2 extends DateV1 {

    private Calendar cal;

    public DateV2(Date date) {
        super(date);
        cal = Calendar.getInstance();
        cal.setTime(date);      
    }

    public int getYear() {
        return cal.get(Calendar.YEAR);
    }
}