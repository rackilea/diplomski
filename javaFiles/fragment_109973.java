@Override
public void serialize(ResponseValues responseValues, JsonGenerator gen,
        SerializerProvider provider) throws IOException,
        JsonProcessingException {

    String stringValue = responseValues.getStringValue();
    if (stringValue != null) {
        gen.writeString(responseValues.getStringValue());
        return; // if string value is valid, write it and return
    }

    int intValue = responseValues.getIntValue();
    // let's suppose 0 is not a valid status
    if (intValue != 0) { 
        gen.writeNumber(intValue);
        return;
        // also you can use gen.writeString(String.valueOf(intValue)); if you need a String
    }

    boolean booleanValue = responseValues.getBooleanValue();
    gen.writeBoolean(booleanValue);

}