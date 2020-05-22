public class CharsetConverter implements Converter<String, String> {
    @Override
    public String from(String databaseObject) {
        return databaseObject == null ? null : 
            new String(databaseObject.getBytes(), "UTF-8"));
    }

    @Override
    public String to(String userObject) {
        return userObject == null ? null : 
            new String(userObject.getBytes(), "ISO 8859-1"));
    }

    @Override
    public Class<String> fromType() { return String.class; }

    @Override
    public Class<String> toType() { return String.class; }
}