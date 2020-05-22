import java.text.DecimalFormat;
import org.joda.time.DateTime;
public class Collectionss {
    public static void main(String[] args){
        DecimalFormat df = new DecimalFormat("00");
        org.joda.time.DateTime dateTime = new DateTime();
        System.out.println(" Year : "+dateTime.getYear());      
        System.out.println(" Month : "+ df.format(dateTime.getMonthOfYear()));
        System.out.println(" Day : "+dateTime.getDayOfMonth()); 
    }

}