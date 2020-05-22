class XMLGregorianCalendarSerializer extends StdSerializer<XMLGregorianCalendar> {

    public XMLGregorianCalendarSerializer() {
        this(null);
    }

    public XMLGregorianCalendarSerializer(Class<XMLGregorianCalendar> t) {
        super(t);
    }

    @Override
    public void serialize(XMLGregorianCalendar value, JsonGenerator gen, SerializerProvider provider)
        throws IOException
    {
        gen.writeNumber(value.toGregorianCalendar().getTimeInMillis());
    }

    @Override
    public void serializeWithType(XMLGregorianCalendar value, JsonGenerator gen, SerializerProvider provider,
        TypeSerializer typeSerializer) throws IOException
    {
        gen.writeStartArray();
        gen.writeString("javax.xml.datatype.XMLGregorianCalendar");
        serialize(value, gen, provider); // call your customized serialize method
        gen.writeEndArray();
    }
}