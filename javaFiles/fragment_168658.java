MySingleton.getRequestQueue().cancelAll(new RequestQueue.RequestFilter() {
    @Override
    public boolean apply(Request<?> request) {
        return true;
    }
});