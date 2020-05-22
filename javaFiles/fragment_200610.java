public abstract class NetworkAsyncCallback<T> implements AsyncCallback<T> {
    @Override
    public void onFailure(Throwable t) {
        if (e instanceof StatusCodeException) {
            logger.log(Level.ERROR, "Exception caught!");
            logger.log(Level.ERROR, ((StatusCodeException) e).getStatusCode());
        }
    }
}