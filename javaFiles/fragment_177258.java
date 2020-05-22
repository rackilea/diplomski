import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CompareDates {

    public static void main(String[] args){
        List<Date> dates = new ArrayList<Date>();
        Date date1 = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Date date2 = new GregorianCalendar(2015, Calendar.MARCH, 2).getTime();
        Date date3 = new GregorianCalendar(2016, Calendar.JANUARY, 4).getTime();
        Date date4 = new GregorianCalendar(2017, Calendar.MARCH, 17).getTime();
        Date date5 = new GregorianCalendar(2017, Calendar.FEBRUARY, 12).getTime();
        Date date6 = new GregorianCalendar(2017, Calendar.JULY, 14).getTime();

        dates.add(date1);
        dates.add(date2);
        dates.add(date3);
        dates.add(date4);
        dates.add(date5);
        dates.add(date6);

        Date minDate = dates.get(0);
        Date maxDate = dates.get(0);

        for(int i=1; i < dates.size(); i++){
            if(dates.get(i).before(minDate)){
                minDate = dates.get(i);
            }
            if(dates.get(i).after(maxDate)){
                maxDate = dates.get(i);
            }
        }

        System.out.println("Min date is ---"+minDate);
        System.out.println("Max date is ---"+maxDate);

    }
}