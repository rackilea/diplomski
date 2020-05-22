public class ValueOrErrorDeserializer<V> implements JsonDeserializer<ValueOrError<V>> {
  public ValueOrError<V> deserialize(JsonElement json, Type typeOfT,
                                     JsonDeserializationContext context) {
    JsonObject object = json.getAsJsonObject();
    JsonElement error = object.get("error");
    if (error != null) {
      ErrorEntity entity = context.deserialize(error, ErrorEntity.class);
      return ValueOrError.<V>error(entity);
    } else {
      Type valueType = ((ParameterizedType) typeOfT).getActualTypeArguments()[0];
      V value = (V) context.deserialize(json, valueType);
      return ValueOrError.value(value);
    }
  }
}