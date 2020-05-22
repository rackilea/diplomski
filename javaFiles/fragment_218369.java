public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> type) {
    ...

    // typeFieldName is the type name that is given when registering the sub type
    if (jsonObject.has(typeFieldName)) {
        throw new JsonParseException("cannot serialize " + srcType.getName()
            + " because it already defines a field named " + typeFieldName);
    }

    ...
}