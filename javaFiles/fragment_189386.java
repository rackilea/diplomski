ClientResponse response = webResource.accept("application/json")
        .type("application/json").get(ClientResponse.class);
String s = response.getEntity(String.class);
JSONParser parser = new JSONParser();
Object obj = parser.parse(s);
JSONObject jsonObject = (JSONObject) obj;
JSONArray jsonArray = (JSONArray) jsonObject.get("prospectList");