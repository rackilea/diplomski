List<Foo> foos = new ArrayList<Foo>();
    JsonArray response = jsonObject.getAsJsonArray("response");
    for (int i = 0; i < response.size(); i++) {
        JsonElement el = response.get(i);
        if (el.isJsonObject()) {
            Foo f = new Foo();
            JsonObject o = el.getAsJsonObject();
            int id = o.getAsJsonPrimitive("id").getAsInt();
            String name = o.getAsJsonPrimitive("name").getAsString();
            f.Id = id;
            f.Name = name;      
            foos.add(f);
        }
    }