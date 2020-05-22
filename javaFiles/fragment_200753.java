List<Foo> foos = new ArrayList<Foo>();
    JsonArray response = jsonObject.getAsJsonArray("response");
    for (int i = 0; i < response.size(); i++) {
        JsonElement el = response.get(i);
        if (el.isJsonObject()) {
            JsonObject o = el.getAsJsonObject();
            Foo f = gson.fromJson(o, Foo.class);
            foos.add(f);
        }
    }