while ((line = reader.readLine()) != null) {
            buffer.append(line);
            Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

        }

        String json = buffer.toString();
try {
  String json = "";
  JSONObject jsonObject = new JSONObject(json);
  JSONObject league = jsonObject.getJSONObject("league");
  JSONArray standard = league.getJSONArray("standard");
  for (int i = 0;i<standard.length();i++){
    JSONObject item = standard.getJSONObject(i);
    String name = item.getString("firstName");
    String lastName= item.getString("lastName");
  }
} catch (JSONException e) {
  e.printStackTrace();
}