String jsonString = "{\"categories\":[2,8],\"tags\":[50,51,54]}";
    JSONObject jsonObject = new JSONObject(jsonString);
    JSONArray tagsArray = jsonObject.getJSONArray("tags");
    // Transfer JSONArray to an int[] array.
    int tags[] = new int[tagsArray.length()];
    for (int i=0; i<tagsArray.length(); i++) {
        tags[i] = tagsArray.getInt(i);
    }