JsonParser parser = new JsonParser();
JsonElement element = parser.parse(loadJSONFromAsset());
JsonObject obj = element.getAsJsonObject();
JsonObject cost = obj.getAsJsonObject("cost");
JsonPrimitive sign = cost.get("currency").getAsJsonPrimitive();

TextView tv = (TextView)findViewById(R.id.dollar_sign);
tv.setText(sign.getAsString());