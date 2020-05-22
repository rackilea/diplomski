try {
    JSONObject reader = new JSONObject("your json str");

    JSONArray items = reader.getJSONArray("worldpopulation");
    for (int i = 0; i < items.length(); ++i) {
        JSONObject jsonProgram = items.getJSONObject(i);
        JSONObject yourObject = null;
        if (i == 0) {
            yourObject = jsonProgram.getJSONObject("0");
        } else {
            yourObject = jsonProgram.getJSONObject("1");
        }

        //Do here what did before with yourObject

    }
} catch (JSONException e) {
    Log.i("Test", e.toString());
}