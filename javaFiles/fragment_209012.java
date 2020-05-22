import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.jsefa.common.converter.ConversionException;
import org.jsefa.common.converter.SimpleTypeConverter;
import org.jsefa.common.converter.SimpleTypeConverterConfiguration;

public class DateConverter implements SimpleTypeConverter {
    private static final String DEFAULT_FORMAT = "dd MMM yyyy hh:mm:ss a";

    private final SimpleDateFormat dateFormat;

    public static DateConverter create(SimpleTypeConverterConfiguration configuration) {
        return new DateConverter(configuration);
    }

    protected DateConverter(SimpleTypeConverterConfiguration configuration) {
        String format = getFormat(configuration);
        try {
            this.dateFormat = new SimpleDateFormat(format, Locale.US);
            this.dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));            
        } catch (Exception e) {
            throw new ConversionException("Could not create a " + this.getClass().getName() + "  with format "
                    + format, e);
        }
    }

    @Override
    public Object fromString(String str) {
        try {
            return (Date) dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString(Object obj) {
        return dateFormat.format((Date) obj);
    }

    protected String getDefaultFormat() {
        return DateConverter.DEFAULT_FORMAT;
    }

    private String getFormat(SimpleTypeConverterConfiguration configuration) {
        if (configuration.getFormat() == null) {
            return getDefaultFormat();
        }
        if (configuration.getFormat().length != 1) {
            throw new ConversionException("The format for a DateConverter must be a single String");
        }
        return configuration.getFormat()[0];
    }
}