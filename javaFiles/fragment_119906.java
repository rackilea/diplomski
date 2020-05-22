serviceCall.enqueue(new CallbackWithRetry<List<Album>>(serviceCall) {
    @Override
    public void onResponse(Response<List<Album>> response) {
        ...
    }
});