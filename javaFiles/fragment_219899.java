@Converter(autoApply = true)
public class SpecialCharacterConverter implements AttributeConverter<SpecialCharacter, String> {

    /**
     * Converts a {@link SpecialCharacter} to the correspondig String that is used in the database
     */
    @Override
    public String convertToDatabaseColumn(SpecialCharacter specialCharacter) {
        return specialCharacter.toString();
    }

    /**
     * Converts a String from the database to the corresponding {@link SpecialCharacter}.
     */
    @Override
    public SpecialCharacter convertToEntityAttribute(String dbValue) {
        return SpecialCharacter.valueOfKey(dbValue);
    }

}