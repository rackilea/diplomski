JSONObject responseJson = new JSONObject(response);
    JSONArray rootArray = responseJson.getJSONArray("root");

    JSONObject genderListWrapperJson = rootArray.getJSONObject(0);
    JSONArray genderListJsonArray = genderListWrapperJson.getJSONArray("genderList");

    for (int i = 0; i < genderListJsonArray.length(); i++) {
        JSONObject genderJson = genderListJsonArray.getJSONObject(i);
        String genderId = genderJson.getString("gender_id");
        String genderName = genderJson.getString("gender_name");
        // TODO: instantiate an object of custom type gender
    }

    JSONObject socialCategoryWrapperJson = rootArray.getJSONObject(1);
    JSONArray socialCategoryJsonArray = socialCategoryWrapperJson.getJSONArray("SocialCategory");

    for (int i = 0; i < socialCategoryJsonArray.length(); i++) {
        JSONObject socialCategoryJson = socialCategoryJsonArray.getJSONObject(i);
        String categoryId = socialCategoryJson.getString("SOCIAL_CATEGORY_ID");
        String categoryName = socialCategoryJson.getString("SOCIAL_CATEGORY_NAME");
        // TODO: instantiate an object of custom social category
    }