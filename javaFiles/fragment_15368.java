import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

       ...

        String sDate = "07/08/2017";
        String eDate = "07/10/2017";

        DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/yyyy");

        LocalDate dateStart = new LocalDate(format.parseLocalDate(sDate));
        LocalDate dateEnd = new LocalDate(format.parseLocalDate(eDate));

        int days = Days.daysBetween(dateStart, dateEnd).getDays();
        for (int i = 0; i < days; i++) {
            LocalDate d = dateStart.withFieldAdded(DurationFieldType.days(), i);
            System.out.println(d);
        }