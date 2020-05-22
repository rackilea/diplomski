.subscribeWith(new DisposableObserver<List<Project>>() {
    @Override
    public void onNext(List<Project> value) {
        try {
            // something that can crash
        } catch (Throwable ex) {
            // tell the upstream we can't accept any more data
            dispose();
            // do the error handling
            onError(ex);
        }
    }
    @Override
    public void onError(Throwable e) {
        handleError(e, 0, "");
        hideProgressDialog();
    }

    @Override
    public void onComplete() {
        hideProgressDialog();
    }
});