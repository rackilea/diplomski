@Plugin(name = "TimePatternConverter", category = PatternConverter.CATEGORY)
@ConverterKeys(value = {"timeIsNow", "timeNow", "now"})
public class TimeConverter extends LogEventPatternConverter {
    protected TimeConverter(String name, String style) {
        super(name, style);
    }

    public static TimeConverter newInstance(String[] options) {
        return new TimeConverter("Time Converter", "now");
    }

    public void format(LogEvent logEvent, StringBuilder toAppendTo) {
        toAppendTo.append(new SimpleDateFormat("HH:mm").format(new Date()));
    }
}