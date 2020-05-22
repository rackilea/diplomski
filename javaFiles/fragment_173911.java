import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
   public static void main(String [] args) throws Exception {
       SimpleDateFormat displayFormat = new SimpleDateFormat("yyyy-MM-dd-HHmm");

       Date date = new Date();//Current Date 
       System.out.println(displayFormat.format(date));
   }
}




See Java Documentation
http://docs.oracle.com/javase/1.5.0/docs/api/java/text/SimpleDateFormat.html