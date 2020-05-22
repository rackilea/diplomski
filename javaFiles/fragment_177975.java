JSONObject currentQuestions = response.getJSONObject(x);
Iterator<String> iter = currentQuestions.keys();
while (iter.hasNext()) {
    String key = iter.next();
    JSONArray arrSubcategory=currentQuestions.optJSONArray(key);
    for (int y = 0; y < arrSubcategory.length(); y++) {
       JSONObject objectSubcategory = arrSubcategory.getJSONObject(y);
       String text = objectSubcategory.optString("text");
    }
}