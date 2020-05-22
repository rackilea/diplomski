import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SimpleDateFormatClass 
{
    public static void main(String args[]) throws Exception
    {
         DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            String str_date ="2012-12-01";
            String end_date ="2012-12-10";
            Date startDate = (Date) formatter.parse(str_date);
            Date endDate = (Date) formatter.parse(end_date);
            Calendar cal = Calendar.getInstance();
            Calendar cal1 = Calendar.getInstance();
            cal.setTime(startDate);
            cal1.setTime(endDate);
    while (!cal.equals(cal1))
    {       
                cal.add(Calendar.DATE, 1);      

         String days="Fri,mon,tue";
          for (String retval: days.split(","))
            {
        SimpleDateFormat sdf= new SimpleDateFormat("EEEE");
        Date date1= sdf.parse(retval);

              if(date1.getDay()==cal.get(Calendar.DAY_OF_WEEK))
                  {
                       System.out.println(cal.getTime());
                  }
           // System.out.println(date1);
           }
    }//While
    }//Main
}