public class ISO8601WithMillisFormat extends ISO8601DateFormat {
    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        String value = ISO8601Utils.format(date, true); // "true" to include milliseconds
        toAppendTo.append(value);
        return toAppendTo;
    }
}