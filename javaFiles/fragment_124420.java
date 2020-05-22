class CustomListConverter implements JsonDeserializer<CustomList<?>> {
    public CustomList deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctx) {
        Type valueType = ((ParameterizedType) typeOfT).getActualTypeArguments()[0];

        CustomList<Object> list = new CustomList<Object>();
        for (JsonElement item : json.getAsJsonArray()) {
            list.add(ctx.deserialize(item, valueType));
        }
        return list;
    }
}