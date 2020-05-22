QueryJsonArray obj = new QueryJsonArray(new Callback() {
    public void call(JSONArray array) {
        //TODO: here you can handle the array
    }
});
JSONArray jArray = obj.execute(myUrl);