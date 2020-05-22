public class Converters {

    public static StringConverter<LocalDate> myAwesomeConverter() {
        DateTimeFormatter formatter = ...;
        return new LocalDateStringConverter(formatter, formatter);
    }

}