@Converter
public class LongStringConverter implements AttributeConverter<Long, String> {
    @Override
    public String convertToDatabaseColumn(Long value) {
        return Long.toString(value);
    }

    @Override
    public Long convertToEntityAttribute(String dbData) {
        return Long.parseLong(dbData);
    }
}