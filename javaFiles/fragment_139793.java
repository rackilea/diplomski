public class DateAdapter {
    private static DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMdd");

    public static LocalDate unmarshal(String v) throws Exception {
        return fmt.parseLocalDate(v);
    }

    public static String marshal(LocalDate v) throws Exception {
        return v.toString("yyyyMMdd");
    }
 }