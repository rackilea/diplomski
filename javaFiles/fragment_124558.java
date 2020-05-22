class MyResponse {
    public int status;
    public List<APIMethod> methods;

    public MyResponse(int status, List<APIMethod> methods) {
        this.status = status;
        this.methods = methods;
    }
}


class MyDeserializer implements JsonDeserializer<MyResponse> {

    public MyResponse deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException
    {
        Gson g = new Gson();
        List<APIMethod> list = new ArrayList<APIMethod>();
        JsonObject jo = je.getAsJsonObject();
        Set<Entry<String, JsonElement>> entrySet = jo.getAsJsonObject("result").entrySet();
        for (Entry<String, JsonElement> e : entrySet) {
            APIMethod m = g.fromJson(e.getValue(), APIMethod.class);
            list.add(m);
        }

        return new MyResponse(jo.getAsJsonPrimitive("status").getAsInt(), list);
    }
}