public void serialize (Date value, JsonGenerator gen, SerializerProvider arg)
    throws IOException, JsonProcessingException {
    synchronized(formatter) {
        gen.writeString(formatter.format(value));
    }
}