public class EnumMarshaller implements DynamoDBMarshaller<Enum> {
    @Override
    public String marshall(Enum getterReturnResult) {
        return getterReturnResult.name();
    }

    @Override
    public Enum unmarshall(Class<Enum> clazz, String obj) {
        return Enum.valueOf(clazz, obj);
    }
}