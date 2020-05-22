private void parseJsonObject(JSONObject responseJsonObject) throws JSONException {

    ArrayList<Object> MARKET_CAP_ARRAY_LIST = new ArrayList<>();

    JSONArray marketCapArray = responseJsonObject.optJSONArray("market_cap");

    for (int i=0; i< marketCapArray.length(); i++){

        JSONArray array1 = (JSONArray) marketCapArray.get(i);

        for (int j=0; j < array1.length(); j++){

            MARKET_CAP_ARRAY_LIST.add(array1.get(j));

        }

    }

}