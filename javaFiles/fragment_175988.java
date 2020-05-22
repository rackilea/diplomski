@HandleClassMetadata
@WithoutBeanView
public final static class FloatConverter implements Converter<Float> {

    public Float deserialize(ObjectReader reader, Context ctx) {
        return reader.valueAsFloat();
    }

    public void serialize(Float obj, ObjectWriter writer, Context ctx) {
        writer.writeValue(obj.floatValue());
    }
}