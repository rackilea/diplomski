import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatConverter {

    private String inputDateFormat;
    private String outputDateFormat;

    private DateFormatConverter (String inputDateFormat, String outputDateFormat) {
        this.inputDateFormat = inputDateFormat;
        this.outputDateFormat = outputDateFormat;
    }

    private String convert(String inputDate) throws ParseException {
        SimpleDateFormat idf = new SimpleDateFormat(inputDateFormat);
        SimpleDateFormat odf = new SimpleDateFormat(outputDateFormat);
        Date date = idf.parse(inputDate);
        String outputDate = odf.format(date);
        return outputDate;
    }

    public static String toJulian(String inputFormat, String inputDate) throws ParseException {
        String suffixFormat = "yyDDD";
        String prefixFormat = "yyyy";
        String suffix = new DateFormatConverter(inputFormat, suffixFormat).convert(inputDate);
        int centuryPrefix = Integer.parseInt(new DateFormatConverter(inputFormat, prefixFormat).convert(inputDate).substring(0, 2))-19;
        return centuryPrefix+suffix;
    }

    public static void main(String[] args) throws ParseException {
        String jd = DateFormatConverter.toJulian("dd-MMM-yyyy", "01-Jan-2017");
        System.out.println(jd);
    }

}