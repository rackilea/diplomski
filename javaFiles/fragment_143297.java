public void write(JsonWriter writer, MyClass object) throws IOException {
    if (object == null) {
        writer.nullValue();
        return;
    }
    writer.beginObject();
    writer.name("type").value(object.getType().toString()); //this is the enum
    writer.endObject();
}