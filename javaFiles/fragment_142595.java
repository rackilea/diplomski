private void parseResult_GetWebData(String result) {
    try {
        JSONObject response = new JSONObject(result);
        JSONArray jsonArray = response.getJSONArray("schools");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.optJSONObject(i);
            JSONArray jsonArray1 = jsonObject.getJSONArray("A");

            List<SchoolClass> schoolClassList = new ArrayList<>();

            for (int k = 0; k < jsonArray1.length(); k++) {
                JSONObject jsonObject1 = jsonArray1.optJSONObject(k);
                String name = jsonObject1.optString("name");

                SchoolClass schoolClass = new SchoolClass();
                schoolClass.setName(name);
                schoolClassList.add(schoolClass);
            }

        }

    } catch (JSONException e) {
        e.printStackTrace();
    }
}