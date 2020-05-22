public class LabelDateFormatter  extends AbstractFormatter {
    private String datePatern = "dd/MM/yyyy";

    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePatern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }
}