@Override
public ListProperty<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
        JsonParseException {
    Type elementType = ((ParameterizedType) typeOfT).getActualTypeArguments()[0];
    Type listType = new CustomParametrizedType(ObservableList.class, null, elementType);
    ObservableList<?> list = context.deserialize(json, listType);
    return new SimpleListProperty<>(list);
}