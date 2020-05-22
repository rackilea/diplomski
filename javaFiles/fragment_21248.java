import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class GregorianCalendarTest {

    public static void main(String[] args) {
        String fromSettingTimeZoneBeforeCall = createString(true);
        String fromSettingTimeZoneAfterCall = createString(false);

        System.out.println("Before: "+fromSettingTimeZoneBeforeCall);
        System.out.println("After : "+fromSettingTimeZoneAfterCall);
    }

    private static String createString(boolean setTimeZoneBeforeCall)
    {
        try {
            XMLGregorianCalendar date = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar("2014-10-25T22:00:00Z");
            int days = 1;

            GregorianCalendar gregorianCalendar = date.toGregorianCalendar();
            System.out.println("After creating: "+gregorianCalendar);

            if (!setTimeZoneBeforeCall)
            {
                gregorianCalendar.getTimeInMillis(); 
                System.out.println("After millis  : "+gregorianCalendar);
            }

            gregorianCalendar.setTimeZone(TimeZone.getDefault());
            System.out.println("After timezone: "+gregorianCalendar);

            if (setTimeZoneBeforeCall)
            {
                gregorianCalendar.getTimeInMillis(); 
                System.out.println("After millis  : "+gregorianCalendar);
            }

            gregorianCalendar.add(Calendar.DAY_OF_MONTH, days);
            System.out.println("After adding  : "+gregorianCalendar);

            XMLGregorianCalendar newXMLGregorianCalendar = DatatypeFactory
                .newInstance().newXMLGregorianCalendar(gregorianCalendar);
            System.out.println("After all     : "+gregorianCalendar);

            return newXMLGregorianCalendar.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}