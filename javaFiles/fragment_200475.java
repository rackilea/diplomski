class OuterObject {
    String build;
    List<InnerObject> objectList = new ArrayList<InnerObject>();
}

class InnerObject {
    int field1, field2, field3, field4, field5, field6, field7, field8;

    public InnerObject(int[] params) {
        // assign params accordingly
    }
}

class MyDeserializer implements JsonDeserializer<OuterObject> {
    @Override
    public OuterObject deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException
    {
        OuterObject oo = new OuterObject();
        JsonObject jo = je.getAsJsonObject();

        oo.build = jo.get("build").getAsString();
        JsonArray innerObjArrays =  jo.getAsJsonArray("list");
        for (JsonElement e : innerObjArrays)
        {
            JsonArray innerArray = e.getAsJsonArray();
            // This is ugly but should give you the gist
            InnerClass ic = new InnerClass((int[])jdc.deserialize(innerArray, int[].class));
            oo.objectList.add(ic);
        }

        return oo;
    }

}