public class RetailerDeserializer implements JsonDeserializer<Retailer> {

    @Override
    public Retailer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject retailerObject = json.getAsJsonObject();
        final String name = retailerObject.get("name").getAsString();
        JsonArray innerImagesArray = retailerObject.get("innerImages").getAsJsonArray();
        String innerImages = null;
        if (innerImagesArray != null) {
            final String[] innerImagesArr = new String[innerImagesArray.size()];
            for (int i = 0; i < innerImagesArray.size(); i++) {
                innerImagesArr[i] = innerImagesArray.get(i).getAsString();
            }
            innerImages = TextUtils.join(" ", innerImagesArr);
        }
        return new Retailer(name, innerImages);
    }
}