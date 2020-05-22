@Converter
public class BooleanConverter implements AttributeConverter<Boolean, String> {

    @Override
    public Character convertToDatabaseColumn(Boolean value) {
        if (value != null) {
            if (value) {
                return '1';
            } else {
                return '0';
            }

        }
        return null;
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        if (value != null) {
            return !value.equals('0');
        }
        return null;
    }

}