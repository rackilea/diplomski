api.getList(URL, paramsMap, new GetListCallback<Comment>() {
    @Override
    public void onSuccess(List<Comment> list) {
        // do something
    }

    @Override
    public void onFailure() {
        // do something
    }
});