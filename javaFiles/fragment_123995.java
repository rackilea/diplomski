public static class BlockDeserializer implements JsonDeserializer<Block> {

    @Override
    public Block deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json == null)
            return null;
        else {
            Block block = new Block();
            JsonObject jo = json.getAsJsonObject();
            JsonArray ja = jo.getAsJsonArray("shape");

            List<Shape> shapes = new ArrayList<Shape>();

            for(JsonElement je : ja) {
                JsonObject jeo = je.getAsJsonObject();

                if(jeo.get("radius") != null) {             
                    shapes.add(new Gson().fromJson( jeo , Circle.class));                       
                } else {
                    shapes.add(new Gson().fromJson( jeo , Square.class));           
                }
            }

            block.shape = shapes;

            return block;
        }
    }
}