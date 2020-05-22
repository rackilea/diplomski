private static class ParcelSerializer implements JsonSerializer<Parcel> {
    @Override
    public JsonElement serialize(Parcel src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject obj = new JsonObject();
        obj.addProperty("area", src.area);
        obj.addProperty("type", src.type);
        JsonObject addrObj = context.serialize(src.address, Address.class).getAsJsonObject();
        for(Map.Entry<String, JsonElement> e : addrObj.entrySet()) {
            obj.add("Address."+e.getKey(), e.getValue());
        }
        return obj;
    }
}