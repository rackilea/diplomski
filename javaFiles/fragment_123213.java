public class LocalDateTimeToDate implements Converter<LocalDateTime, Date> {

    @Override
    public Date convert(LocalDateTime source) {
        return source == null ? null : Date.from(source.toInstant(ZoneOffset.UTC));
    }

}