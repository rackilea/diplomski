public abstract class ResponsiveAsyncCallback<T> implements AsyncCallback<T> {

    public void onFailure(Throwable caught) {
        if(caught instanceof InvocationException) {
            // Failed to connect to the server
            // Do what you like here, maybe create an event
        }
    }
}