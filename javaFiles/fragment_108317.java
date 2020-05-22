@Converter
public class SexConverter implements AttributeConverter<Sex, Character> {


    @Override
    public Character convertToDatabaseColumn(Sex sex) {
        return sex.getName();
    }

    @Override
    public Sex convertToEntityAttribute(Character dbData) {
        return Sex.getByName(dbData);
    }
}