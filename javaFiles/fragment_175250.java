import java.sql.Timestamp;
import java.util.Date;

public class GetCurrentTimeStamp 
{
    public static void main( String[] args )
    {
       java.util.Date date= new java.util.Date();
       Log.v("Time",new Timestamp(date.getTime()));
    }
}