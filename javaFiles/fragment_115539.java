try {
        JSONObject jsonObject = new JSONObject(thatarray);
        jsonObject = jsonObject.getJSONObject("response");
        JSONArray jsonArray = jsonObject.getJSONArray("data");

        JSONArray jsonArraysubject;
        for (int i = 0; i < jsonArray.length() - 1; i++) {
            jsonObject = jsonArray.getJSONObject(i);
            jsonArraysubject = jsonObject.getJSONArray("subjects");

            Log.d("MyLog", jsonArraysubject + "");
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }