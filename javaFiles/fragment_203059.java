public class ResponseListener implements AsyncListener {

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
    }

    @Override
    public void onComplete(AsyncEvent event) throws IOException {
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        event.getAsyncContext().getResponse().getWriter().print("error:");
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        event.getAsyncContext().getResponse().getWriter().print("timeout:");
    }

}