public JsonElement serialize(Collection<E> collection, Type type,
                             JsonSerializationContext context) {
    JsonArray result = new JsonArray();
    for(E item : collection){
        result.add(context.serialize(item));
    }
    return new JsonPrimitive(result.toString());
}