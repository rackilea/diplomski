JsonParser parser = new JsonParser();
    JsonObject o = parser.parse(jsonStr).getAsJsonObject();
    JsonElement latLng = o.get("results")
            .getAsJsonArray().get(0)
            .getAsJsonObject().get("locations")
            .getAsJsonArray().get(0)
            .getAsJsonObject().get("latLng");