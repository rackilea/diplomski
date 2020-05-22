public class DateFactory{
    public Date makeDate(){
        return new Date();
    }
}

-----------------------------------

public class MyDate extends GregorianCalendar implements Comparable<Calendar>{

    public MyDate(){
        this(new DateFactory());
    }

    MyDate(DateFactory factory){
        setTime(factory.makeDate());
    }
}