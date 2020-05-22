public abstract class AbstractAttributeConverter<E extends MyEnum<E>> implements AttributeConverter<E, String> {

    protected MyEnum<E> myEnum;

    @Override
    public String convertToDatabaseColumn(E attribute) {
        return myEnum.toString(attribute);
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        return myEnum.fromString(dbData);
    }
}