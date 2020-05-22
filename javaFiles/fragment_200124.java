public class MyIDConverter implements AttributeConverter<ID, String> {

    @Override
    public String convertToDatabaseColumn(ItStaticDataKey javaKey) {
        // your implementation here
    }

    @Override
    public ItStaticDataKey convertToEntityAttribute(final String databaseKey) {
        // your implementation here
    }

}