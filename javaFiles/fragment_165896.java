import java.util.GregorianCalendar;
 import java.util.Calendar;

 public class CalcAge {

   public static void main(String [] args) {
     // remember ... months are 0-based : jan=0 feb=1 ...
     System.out.println
       ("1962-11-11 : " + age(1962,10,11));
     System.out.println
       ("1999-12-03 : " + age(1999,11,3));
   }

   private static int age(int y, int m, int d) {
     Calendar cal = new GregorianCalendar(y, m, d);
     Calendar now = new GregorianCalendar();
     int res = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
     if((cal.get(Calendar.MONTH) > now.get(Calendar.MONTH))
       || (cal.get(Calendar.MONTH) == now.get(Calendar.MONTH)
       && cal.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH)))
     {
        res--;
     }
     return res;
   }
}