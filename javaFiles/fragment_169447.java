public class DozerConverter implements CustomConverter {
    @Override
    public Object convert(Object destination, Object source, Class destClass, Class sourceClass) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        if(source instanceof String) {
            String sourceTime = (String) source;
            return LocalDateTime.parse(sourceTime, formatter);
        } else if (source instanceof LocalDateTime) {
            LocalDateTime sourceTime = (LocalDateTime) source;
            return sourceTime.toString();
        }
        return null;
    }