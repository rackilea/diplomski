try {
        JSONObject jsonObject = new JSONObject(string);
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        String array[] = new String[jsonArray.length()];
        for(int i=0;i<jsonArray.length();i++){
            array[i] = String.valueOf(jsonArray.getJSONObject(i));
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }