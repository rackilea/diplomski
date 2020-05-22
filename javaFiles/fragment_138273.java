try {
    int[] ids = { 100, 200, 300 };
    JSONObject mainObject = new JSONObject();
    JSONArray recipients = new JSONArray();
    for (int id : ids) {
        JSONObject idsJsonObject = new JSONObject();
        idsJsonObject.put("@id", id);
        recipients.put(idsJsonObject);
    }
    mainObject.put("recipients", recipients);
    System.out.println(mainObject.toString());
} catch (JSONException e) {
    e.printStackTrace();
}