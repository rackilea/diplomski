JSONObject currentQuestions = response.getJSONObject(x);
JSONArray arrSubcategory=currentQuestions.optJSONArray("Subcategory");
for (int y = 0; y < arrSubcategory.length(); y++) {
   JSONObject objectSubcategory = arrSubcategory.getJSONObject(y);
   String text = objectSubcategory.optString("text");
}