List<String> radioData = new ArrayList<String>();

    Object obj=JSONValue.parse("**String you have**");
    JSONArray data = (JSONArray)obj
    for (int i=0; i<data.length(); i++) {
        JSONObject jasonObj = data.getJSONObject(i);

        String field1 = actor.getString("FIELD1");
        radioData.add(field1);

        // Like this you can fetch whole data



    }