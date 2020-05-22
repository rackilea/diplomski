$.ajax(new AjaxOptions().url(myUrl).success(new Function() {
    public void invoke($ d, Object… args) {
        JSONArray array = (JSONArray) args[0];
        //TODO handle the json array.
    }
});