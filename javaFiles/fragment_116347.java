import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo  {

    public static void main(String[] args) {
        try{
            String date = "22-May-2015";
            String time = "7:20";
            String yourString = date+ " "+ time;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
            Date parsedDate = dateFormat.parse(yourString);
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            System.out.println(timestamp);
        }catch(Exception e){
            e.printStackTrace();
            //this generic but you can control another types of exception
            // look the origin of excption 
        }
    }
    }