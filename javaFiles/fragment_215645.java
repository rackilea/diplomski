public class CustomPrimitiveByteArrayTypeDescriptor extends PrimitiveByteArrayTypeDescriptor {
    public static final CustomPrimitiveByteArrayTypeDescriptor INSTANCE = new CustomPrimitiveByteArrayTypeDescriptor();

    @Override
    public String extractLoggableRepresentation(byte[] value) {
        if (null == value) {
            return super.extractLoggableRepresentation(value);
        } else {
            return "byte[" + value.length + "]";
        }
    }
}