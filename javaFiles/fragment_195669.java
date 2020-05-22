@Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        bus.register(this);
        try {
             JSONObject jsonObject = new JSONObject(jsonString);
             bus.post(new GetCategoryEvent( Item.fromJson(jsonObject));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }