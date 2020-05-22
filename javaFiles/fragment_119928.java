import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDateFormat {

    public static void main(String[] args){
        String inputStringDate = "12.02.2014";
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date inputDate = null;
        try {
            inputDate = inputFormat.parse(inputStringDate);
        } catch (ParseException ex) {
            Logger.getLogger(MyDateFormat.class.getName()).log(Level.SEVERE, null, ex);
        }

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss:SSS");
        String outputStringDate = outputFormat.format(inputDate);

        System.out.println(outputStringDate);      
    }
}