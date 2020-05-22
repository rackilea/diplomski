@Component
public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {
private final DateTimeFormatter formatter;

@Autowired
public LocalDateTimeConverter(@Value("${dateTime.format}") String dateTimeFormat) {
    this.formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
}

@Override
public LocalDateTime convert(String source) {
    if (source == null || source.isEmpty()) {
        return null;
    }

    return LocalDateTime.parse(source, formatter);
}
}