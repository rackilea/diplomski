import java.util.*
import java.text.DateFormat.*;

    public class StringToDateTimeConverter extends StrutsTypeConverter{

        public Object convertFromString(Map context, String[] strings, Class toClass) {     

            DateFormat DATETIME_FORMAT = getDateInstance(SHORT, Locale.getDefault());

            if (strings == null || strings.length == 0 || strings[0].trim().length() == 0) {
                return null;
            }

            try
            {
                DATETIME_FORMAT.setLenient(false);
                return DATETIME_FORMAT.parseObject(strings[0]);

            } catch (ParseException e) {
                //throw new TypeConversionException(); <-- if you want to catch conversion error
                return null;
            }
        }

        public String convertToString(Map context, Object date) {
            DateFormat DATETIME_FORMAT = getDateInstance(SHORT, Locale.getDefault());
            if (date != null && date instanceof Date) {
                return DATETIME_FORMAT.format(date);
            } else {
                return null;
            }
        }
    }