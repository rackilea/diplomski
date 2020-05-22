class JTFormater extends JFormattedTextField.AbstractFormatter{
    final DateTimeFormatter formatter;
    public JTFormater(DateTimeFormatter formatter){
        this.formatter =  formatter;
    }
    @Override
    public Object stringToValue(String text) throws ParseException {
        return formatter.parse(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if(value instanceof TemporalAccessor){
            return formatter.format((TemporalAccessor) value);
        } else{
            throw new ParseException("not a valid type at", 0);
        }
    }
}