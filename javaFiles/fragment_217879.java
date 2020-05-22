private ProgressDialog progress;
private void showProgress(String message) {
    progress = new ProgressDialog(this);
    progress.setMessage(message);
    progress.setIndeterminate(true);
    progress.show();
}

private void hideProgress() {
    if (progress != null) {
        progress.dismiss();
    }
}