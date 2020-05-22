public class WidgetDeserialization implements JsonDeserializer<WidgetAdapter> {

    /***
     * factory method for custom WidgetAdapter
     * @param json
     * @return WidgetAdapter
     */
    private WidgetAdapter getWidget(JsonObject json){
        WidgetAdapter adapter = null;
        //obtain widget class. Util for instanciate concrete class
        String className = json.get("className").getAsString();
        // create concrete classes and set concrete atributes
        if("text".equals(className)){
            adapter = new TextWidgetAdapter(json.get("text").getAsString());
        }else if("youtube".equals(className)){
            adapter = new YoutubeWidgetAdapter(json.get("videos").getAsString());
        }
        // if adapter is created common atributes are set
        if(adapter!=null){
            adapter.setHeight(json.get("height").getAsInt());
            adapter.setWidth(json.get("width").getAsInt());
            adapter.setX(json.get("x").getAsInt());
            adapter.setY(json.get("y").getAsInt());
        }
        return adapter;
    }

    @Override
    public WidgetAdapter deserialize(JsonElement element, Type arg1,
            JsonDeserializationContext arg2) throws JsonParseException {
        JsonObject obj = element.getAsJsonObject();
        return getWidget(obj);
    }

}