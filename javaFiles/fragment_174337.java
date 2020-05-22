import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Locale;

public class IntegerDateTest {

    public static void main(String args[]) {
        int[][] dates = {{10, 02, 2014}, {02, 10, 2014}, {2014, 10, 02}};
        Locale[] locales = {Locale.ENGLISH, Locale.FRENCH, Locale.JAPANESE};

        for (int i = 0; i < 3; i++) {
            int[] dateParts = dates[i];
            Locale locale = locales[i];
            String date = String.format("%02d/%02d/%02d", dateParts[0] % 100,
                    dateParts[1] % 100, dateParts[2] % 100);
            System.out.printf("Locale : %s, Str Date : %s,", locale, date);
            DateTimeFormatter df = new DateTimeFormatterBuilder().append(
                    DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))
                    .toFormatter(locale);
            System.out.printf(" Parsed Date : %s\n",LocalDate.from(df.parse(date)));
        }
    }
}