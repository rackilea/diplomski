import org.apache.commons.lang.time.DateUtils;
import java.text.SimpleDateFormat;


@Test
public void testDate() throws Exception {

    long t1 = new SimpleDateFormat("dd.MM.yyyy").parse("20.03.2013").getTime();
    long now = System.currentTimeMillis();
    String result = null;
    long diff = Math.abs(t1-now);


    if(diff < DateUtils.MILLIS_PER_MINUTE){
         result =  "few seconds ago";
    }else if(diff < DateUtils.MILLIS_PER_HOUR){
         result = (int)(diff/DateUtils.MILLIS_PER_MINUTE) + " minuts ago";
    }else if(diff < DateUtils.MILLIS_PER_DAY){
        result =  (int)(diff/DateUtils.MILLIS_PER_HOUR) + " hours ago";
    }else if(diff < DateUtils.MILLIS_PER_DAY * 2){
        result = new SimpleDateFormat("'yesterday at' hh:mm a").format(t1);
    }else if(diff < DateUtils.MILLIS_PER_DAY * 365){
        result = new SimpleDateFormat(" MMM d 'at' hh:mm a").format(t1);
    } else{
        result = new SimpleDateFormat("MMM d ''yy 'at' hh:mm a").format(t1);
    }
    result = result.replace("AM", "am").replace("PM", "pm");
    System.out.println(result);


}