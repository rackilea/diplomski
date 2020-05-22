class ThreePointsDeserializer extends StdDeserializer<ThreePoints> {

    protected ThreePointsDeserializer() {
        super(ThreePoints.class);
    }


    @Override
    public ThreePoints deserialize(JsonParser parser, DeserializationContext ctx)
            throws IOException, JsonProcessingException {
        ThreePoints result = new ThreePoints();
        GeoPoint[] points = parser.getCodec().readValue(parser, GeoPoint[].class);
        result.points = Arrays.asList(points);
        return result;
    }
}