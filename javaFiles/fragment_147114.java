import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversion {
   public void convertDate() {
      try{
       SimpleDateFormat df = new SimpleDateFormat("HH:mm");
       SimpleDateFormat pf = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
       Date date = pf.parse("10:20PM");
       System.out.println(pf.format(date) + " = " + df.format(date));
        }catch(Exception e){
        // Do your exception handling over here.
        }
   }
}