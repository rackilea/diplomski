class CallbackFuture extends CompletableFuture<Response> implements Callback {
    public void onResponse(Call call, Response response) {
         super.complete(response);
    }
    public void onFailure(Call call, IOException e){
         super.completeExceptionally(e);
    }
}