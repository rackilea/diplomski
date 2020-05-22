public abstract class AsyncSuccessCallback<T> implements AsyncCallback<T> {

    public void onFailure(Throwable t) {
        handleException(t);
    }

    protected void handleException(Throwable t) {
         Window.alert(t.getMessage());
    }

}