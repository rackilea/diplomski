HttpEventCollectorErrorHandler.onError(new HttpEventCollectorErrorHandler.ErrorCallback() {
    public void error(final List<HttpEventCollectorEventInfo> events, final Exception ex) {
        // FIXME: Dumping stack trace to STDERR is not suitable for production use !
        ex.printStackTrace();
    }
});