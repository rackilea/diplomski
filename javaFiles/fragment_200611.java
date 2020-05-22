myServer.getSomeData(param, new NetworkAsyncCallback<Result>() {
    @Override
    public void onSuccess(Result result) {
        //...
    }
    // Skip onFailure, or if you need custom logic, implement it, 
    // and call super only if the exception isn't part of that logic
});