CallUtils.enqueueWithRetry(serviceCall, new Callback<List<Album>>() {
    @Override
    public void onResponse(Response<List<Album>> response) {
        ...
    }

    @Override
    public void onFailure(Throwable t) {
        // Let the underlying method do the job of retrying.
    }
});