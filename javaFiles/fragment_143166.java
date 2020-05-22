JSONObject baseJsonResponse = new JSONObject(newsJSON);

    JSONObject responseObj = null;
    try {
        responseObj = baseJsonResponse.getJSONObject("response");
        JSONArray resultArray = responseObj.getJSONArray("results");
        int size = resultArray.length();

        for (int i =0;i<size;i++){
            JSONObject myJson = resultArray.getJSONObject(i);
            String sectionName = myJson.getString("sectionName");
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }