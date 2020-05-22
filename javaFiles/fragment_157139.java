private void createJson(String logData) {
        try {
            Log.d("data", logData);
            JSONArray jsonArray = new JSONArray();

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("log", logData);

            jsonArray.put(jsonObj);
            Log.e("Your_JSON",jsonObj.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }