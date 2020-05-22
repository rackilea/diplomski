public class YourEntity {
    @Convert(converter=BooleanOneZeroConverter.class)
    private Boolean playable;
}

@Converter
public class BooleanOneZeroConverter implements AttributeConverter<Boolean, Integer> {
    private static final Integer TRUE_VALUE = 1;
    @Override
    public Integer convertToDatabaseColumn(Boolean value) {
        //1 is true, 0 is false
        return Boolean.TRUE.equals(value) ? 1 : 0;
    }
    @Override
    public Boolean convertToEntityAttribute(Integer value) {
        return TRUE_VALUE.equals(value);
    }
}