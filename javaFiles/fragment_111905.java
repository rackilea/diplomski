public class ManufacturerSerializer extends TypeAdapter<Manufacturer> {
    @Override
    public void write(JsonWriter out, Manufacturer m) throws IOException {
        out.value(m.getName());
        out.name("country");
        out.value(m.getFrom());
    }

    /* I only need Serialization, dont use this */
    @Override
    public Manufacturer read(JsonReader in) throws IOException {
        return null;
    }
}