import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;

class ChangeDateFormat
{
    private String setDate(int day, Locale locale) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +day);
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        if (df instanceof SimpleDateFormat)
        {
            SimpleDateFormat sdf = (SimpleDateFormat) df;
            // To show Locale specific short date expression with full year
            String pattern = sdf.toPattern().replaceAll("y+","yyyy");
            sdf.applyPattern(pattern); 
            return sdf.format(cal.getTime());
        }
        String formattedDate = df.format(cal.getTime());
        return formattedDate;
    }

    public static void main(String[] args)
    {
        ChangeDateFormat cdf = new ChangeDateFormat();        
        System.out.println(cdf.setDate(1, Locale.JAPAN));
    }
}