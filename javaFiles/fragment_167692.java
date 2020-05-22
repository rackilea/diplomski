try {
    JSONObject json = new JSONObject(jsonString);

    if(json.isNull("OrderAttributes")) {
        //TODO: it is null
    } else {
        //TODO: it is not null
        String orderAttributes = json.getString("OrderAttributes");
    }
} catch (JSONException e) {
    e.printStackTrace();
}