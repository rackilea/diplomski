String jsonString="{\"team\": {\"team_id\": \"2\",\"team_name\": \"volcanoe\"},\"member\": [{\"name\": \"Samantha\",\"age\": \"20\"}]}";

JSONObject jsonObject = new JSONObject(jsonString);

JSONArray jsonArrayMember=jsonObject.getJSONArray("member");

System.out.println(jsonArrayMember);