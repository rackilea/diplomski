public class GeometryDeserializer implements JsonDeserializer<Geometry> {

@Override
public Geometry deserialize(JsonElement json, Type typeofT,
        JsonDeserializationContext context) throws JsonParseException {

    String type = json.getAsJsonObject().get("type").toString();

    JsonArray coordinates = json.getAsJsonObject().getAsJsonArray("coordinates");

    GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);
    Coordinate coord = new Coordinate(coordinates.get(0).getAsDouble(), coordinates.get(1).getAsDouble());
    Geometry point = geometryFactory.createPoint(coord);


    return point;
}
}