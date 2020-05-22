class MyJSONObject {
    protected double a = 0.0;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

}

class MyJSONObjectDeserializer implements JsonDeserializer<MyJSONObject> {

    @Override
    public MyJSONObject deserialize(final JsonElement json, final Type typeOfT,
            final JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        MyJSONObject object = new MyJSONObject();

        if (jsonObject.get("a") != null) {
            object.setA(jsonObject.get("a").getAsDouble());
        } else if (jsonObject.get("d") != null) {
            object.setA(jsonObject.get("d").getAsDouble());
        }

        return object;
    }
}

...

String json = "{\"a\":\"9.57\"}";
// String json = "{\"d\":\"9.57\"}";
MyJSONObject data = new GsonBuilder()
        .registerTypeAdapter(MyJSONObject.class, new MyJSONObjectDeserializer()).create()
        .fromJson(json, MyJSONObject.class);

System.out.println(data.getA());