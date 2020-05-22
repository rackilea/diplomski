public class CustomUrlQuerySanitizer extends UrlQuerySanitizer {
    @Override
    protected void parseEntry(String parameter, String value) {
//        String unescapedParameter = unescape(parameter);
        ValueSanitizer valueSanitizer =
                getEffectiveValueSanitizer(parameter);

        if (valueSanitizer == null) {
            return;
        }
//        String unescapedValue = unescape(value);
        String sanitizedValue = valueSanitizer.sanitize(value);
        addSanitizedEntry(parameter, sanitizedValue);
    }
}