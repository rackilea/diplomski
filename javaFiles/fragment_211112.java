JSONObject obj=new JSONObject();
    try {
        String value_key="Value";
        obj.put(value_key, value);
        Log.d(TAG,obj.toString());
    } catch (JSONException e) {
        Log.e(TAG, "Create JSONObjerct throws an error");
    }