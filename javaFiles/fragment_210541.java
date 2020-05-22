@Override
    public String toString() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("id", idField);
            obj.put("name", name);
            obj.put("price", price);
        } catch (JSONException e) {
            Log.e(getClass().getSimpleName(), e.toString());
        }
        return obj.toString();
    }