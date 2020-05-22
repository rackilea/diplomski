import java.util.*;
import java.text.*;

public class StringToDate {
    public static void main(String[] args){
        try{  
            String str_date="Sat Sep 8 10:13:09 GMT+0530 2012";
            DateFormat formatter ; 
            Date date ; 
            formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss 'GMT'z yyyy");
            date = (Date)formatter.parse(str_date);  
            System.out.println("Today is " +date );
        } 
        catch (ParseException e){
            System.out.println("Exception :"+e);  
        }  
    }
}