public enum InputDatePattern
{
    WITH_TIMESTAMP("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d{0,9})?", Optional.of("yyyy-MM-dd'T'HH:mm:ss")), 
    WITHOUT_TIMESTAMP("\\d{4}-\\d{2}-\\d{2}", Optional.of("yyyy-MM-dd")),
    TIMESTAMP_ONLY("\\d{2}:\\d{2}:\\d{2}(\\.\\d{0,9})?", Optional.of("HH:mm:ss")),
    UNKNOWN(".*", Optional.empty()); // must come last, since elements are matched in order
    private final Pattern pattern;
    private final Optional<DateTimeFormatter> formatter;

    private static final LocalDate DEFAULT_DATE = LocalDate.EPOCH;
    private static final LocalTime DEFAULT_TIME = LocalTime.MIDNIGHT;
    private static final Logger log = Logger.getLogger(Logger.class.getName());

    private InputDatePattern(String regex, Optional<String> format)
    {
        pattern = Pattern.compile(regex);
        var formatter = Optional.of(new DateTimeFormatterBuilder());
        formatter.ifPresent(f -> format.ifPresent(f::appendPattern));
        formatter.ifPresent(f -> f.appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true));
        this.formatter = formatter.map(DateTimeFormatterBuilder::toFormatter);
    }

    public boolean matches(String type)
    {
        return pattern.matcher(type).matches();
    }

    public Optional<LocalDateTime> toLocalDateTime(String dateString)
    {
        try
        {
            switch(this)
            {
            case WITH_TIMESTAMP:
                return formatter.map(f -> LocalDateTime.parse(dateString, f).withNano(0));
            case WITHOUT_TIMESTAMP:
                return toLocalDate(dateString).map(date -> date.atTime(DEFAULT_TIME).withNano(0));
            case TIMESTAMP_ONLY:
                return toLocalTime(dateString).map(date -> date.atDate(DEFAULT_DATE).withNano(0));
            case UNKNOWN:
                return Optional.empty();
            default:
                throw new IllegalStateException("Attempting conversion with unknown InputDatePattern!");
            }
        }
        catch(DateTimeParseException e)
        {
            log.info(e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<LocalDate> toLocalDate(String dateString)
    {
        try
        {
            switch(this)
            {
            case WITH_TIMESTAMP:
            case WITHOUT_TIMESTAMP:
                return formatter.map(f -> LocalDate.parse(dateString, f));
            case TIMESTAMP_ONLY:
            case UNKNOWN:
                return Optional.empty();
            default:
                throw new IllegalStateException("Attempting conversion with unknown InputDatePattern!");
            }
        }
        catch(DateTimeParseException e)
        {
            log.info(e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<LocalTime> toLocalTime(String dateString)
    {
        try
        {
            switch(this)
            {
            case WITH_TIMESTAMP:
            case TIMESTAMP_ONLY:
                return formatter.map(f -> LocalTime.parse(dateString, f));
            case WITHOUT_TIMESTAMP:
            case UNKNOWN:
                return Optional.empty();
            default:
                throw new IllegalStateException("Attempting conversion with unknown InputDatePattern!");
            }
        }
        catch(DateTimeParseException e)
        {
            log.info(e.getMessage());
            return Optional.empty();
        }
    }

    public static InputDatePattern forDateString(String dateString)
    {
        for(InputDatePattern pattern : InputDatePattern.values())
        {
            if(pattern.matches(dateString))
                return pattern;
        }
        return InputDatePattern.UNKNOWN;
    }
}