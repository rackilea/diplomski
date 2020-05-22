public class LatLngDeserializer implements JsonDeserializer<LatLng> {

  @Override
  public LatLngdeserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
      throws JsonParseException {

    JsonObject jobject = json.getAsJsonObject();

    return new LatLng(
        jobject.get("lat").getAsDouble(), 
        jobject.get("lng").getAsDouble());
}