JSONObject complete = new JSONObject(WHOLE_JSON_AS_STRING);
JSONObject hforma = complete.getJSONObject("hforma");
JSONArray forma = hforma.getJSONArray("forma");

for (int i = 0; i < forma.length(); i++) {
   JSONObject formaData = forma.getJSONObject(i);
   String hcsapat = formaData.getString("hcsapat");
   String vcsapat = formaData.getString("vcsapat");
}