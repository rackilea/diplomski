public class JodaDateTimeTypeConverter implements TypeConverter<DateTime> {

    @Override
    public DateTime convert(String input, Class<? extends DateTime> type, Collection<ValidationError> errors) {

        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM-dd-yyyy HH:mm");
        DateTime datetime = formatter.parseDateTime(input);
        return datetime;
    }

    @Override
        public void setLocale(Locale arg0) {
    }
}