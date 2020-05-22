public class CharToBooleanConverter implements AttributeConverter<Boolean, String> {
    @Override
    public Boolean convertToEntityAttribute(String s) {
        return s != null && s.equalsIgnoreCase("t");
    }

    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        return (aBoolean != null && aBoolean) ? "t" : "f";
    }
}