@Plugin(name="MyNamePatternConverter", category = PatternConverter.CATEGORY)
@ConverterKeys(value = {"whatIsMyName", "myName"})
public class MyNameConverter extends LogEventPatternConverter {

    protected MyNameConverter(String name, String style) {
        super(name, style);
    }

    public static MyNameConverter newInstance(String[] options) {
        return new MyNameConverter("My name Converter", "name");
    }

    public void format(LogEvent event, StringBuilder toAppendTo) {
        toAppendTo.append("Yuriy");
    }
}