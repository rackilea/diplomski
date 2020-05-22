public class MyReferenceObjectCodeDeserializer implements Deserializer<MyReferenceObjectBean> {

public MyReferenceObjectBeandeserialize(ObjectReader reader, Context ctx) throws TransformationException, IOException {
        MyReferenceObjectBean b = null;
        reader.beginObject();
        while (reader.hasNext()) {
            reader.next();
            if ("code".equalsIgnoreCase(reader.name()))
                b = MyReferenceObjectServiceImpl.retrieveByCode(reader.valueAsString());
        }
        reader.endObject();
        return b;
    }
}

// register it
Genson genson = new Genson.Builder().withDeserializers(new MyReferenceObjectCodeDeserializer()).create();
MyClass myClass = genson.deserialize(json, MyClass.class);