for (int i = 0, len = jsonArray.length(); i < len; i++) {
    JSONObject obj = jsonArray.getJSONObject(i);
    String val = jsonArray.getJSONObject(i).getString();
    if (val.equals("empty")) {            
        jsonArray.remove(i);
    }
}