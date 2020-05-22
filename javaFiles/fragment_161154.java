public class InstantToLongConverter implements Converter<Instant, Long> {
    @Override
    public Long convert(Instant instant) {
        return instant.toEpochMilli();
    }
}

public class LongToInstantConverter implements Converter<Long, Instant> {
    @Override
    public Instant convert(Long source) {
        return Instant.ofEpochMilli(source);
    }
}

public class LocalDateToStringConverter implements Converter<LocalDate, String> {
    @Override
    public String convert(LocalDate localDate) {
        return localDate.toString();
    }
}

public class StringToLocalDateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source);
    }
}