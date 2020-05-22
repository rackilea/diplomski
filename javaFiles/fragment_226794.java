import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeDiff {

    public static void main(String[] args) throws ParseException {
        Date now = new Date();
        System.out.println(now);
        Date birthDate = new SimpleDateFormat("dd-MM-yyyy").parse("7-12-1983");
        System.out.println(birthDate);

        Date age = new Date(now.getTime() - birthDate.getTime());
        Calendar instance = Calendar.getInstance();
        instance.setTime(age);
        instance.add(Calendar.YEAR, -1970);
        SimpleDateFormat sdf = new SimpleDateFormat("d-W-MM-yyyy");
        System.out.println(sdf.format(instance.getTime()));
    }

}