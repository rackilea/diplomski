private void parseJson(String json) {
    try {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("answers");
        for (int i = 0; i < jsonArray.length(); i++){
            String answer = jsonArray.getJSONObject(i).getString("answer");
            Log.i(TAG,"answer: "+answer);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

}