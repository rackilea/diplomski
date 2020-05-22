public static void parse(String response) {
    try {
        JSONObject baseObject = new JSONObject(response);

        if (baseObject == null) {
            return;
        }

        JSONObject responseObj = baseObject.optJSONObject("response");

        if (response == null) {
            return;
        }

        JSONArray resultsArray = responseObj.getJSONArray("results");

        if (resultsArray == null) {
            return;
        }

        for (int i = 0; i < resultsArray.length(); i++) {
            JSONObject resultObj = resultsArray.getJSONObject(i);

            if (resultObj == null) {
                continue;
            }

            String id = resultObj.optString("id", "");
            String type = resultObj.optString("type", "");
            String sectionId = resultObj.optString("sectionId", "");
            String sectionName = resultObj.optString("sectionName", "");
            String webPublicationDate = resultObj.optString("webPublicationDate", "");
            String webTitle = resultObj.optString("webTitle", "");
            String webUrl = resultObj.optString("webUrl", "");
            String apiUrl = resultObj.optString("apiUrl", "");
            boolean isHosted = resultObj.optBoolean("isHosted", false);

            JSONObject fieldsObj = resultObj.optJSONObject("fields");

            if (fieldsObj == null) {
                 continue;
            }

            String headline = fieldsObj.optString("headline", "");
            String lastModified = fieldsObj.optString("lastModified", "");
            String thumbnail = fieldsObj.optString("thumbnail", "");
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }
}