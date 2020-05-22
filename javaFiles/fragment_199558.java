JSONArray jsonarray = new JSONArray(jsonStr); // define json data
    for (int i = 0; i < jsonarray.length(); i++) {
        try {
            String data = jsonarray.get(i).toString();
            Log.d("Data",data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }