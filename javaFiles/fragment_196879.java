List<Chest> list = new ArrayList<>();
for(Entry<String, JsonElement> e : json.entrySet()){
    //read the json you can find in `e.getValue()`
    JsonObject o = e.getValue().getAsJsonObject();
    double x = o.getAsJsonPrimitive("x").getAsDouble();
    ...

    //create the instance `Chest` with those `double` and insert into a `List<Chest>`
    list.add(new Chest(x,y,z));
}