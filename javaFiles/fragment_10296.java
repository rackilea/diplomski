public class CustomRequestBuilder extends RpcRequestBuilder {

 private class RequestCallbackWrapper implements RequestCallback {

        private RequestCallback callback;

        RequestCallbackWrapper(RequestCallback aCallback) {
            this.callback = aCallback;
        }

        @Override
        public void onResponseReceived(Request request, Response response) {
            if(response.getStatusCode() == 409) { //wrong client version
                Navigator.closeEveryPopUp();
                Navigator.showUncloseablePopUp("Login again!", 
                                new ClickHandler() {

                    @Override
                    public void onClick(ClickEvent event) {
                        //reload your $#%^ client!!!
                        Window.Location.reload();
                    }
                });
            } else {
                //(...)irrelevant security code here(...)
                callback.onResponseReceived(request, response);
            }

        }

        @Override
        public void onError(Request request, Throwable exception) {
            callback.onError(request, exception);
        }

 }

 @Override
 protected void doFinish(RequestBuilder rb) {
    //(...)more irrelevant security code here(...)
    super.doFinish(rb);
    rb.setCallback(new RequestCallbackWrapper(rb.getCallback()));
 }
}