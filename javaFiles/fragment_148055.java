public static class GeoJsonPolygonSerializer extends JsonSerializer<GeoJsonPolygon> {

    @Override
    public void serialize(GeoJsonPolygon value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeStringField("type", value.getType());
        gen.writeArrayFieldStart("coordinates");
        for (GeoJsonLineString ls : value.getCoordinates()) {
            gen.writeStartArray();
            for (Point p : ls.getCoordinates()) {
                gen.writeObject(new double[]{p.getX(), p.getY()});
            }
            gen.writeEndArray();
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }
}