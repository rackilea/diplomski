class MyMethodCallbackHandler extends CompletableFuture implements CallbackHandler {
   void onSuccess(Object result) {
      super.complete(result);
   }
   void onError(Throwable error) {
      super.completeExceptionally(error);
   }
}