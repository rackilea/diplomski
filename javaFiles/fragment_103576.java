private void setViewVisibility(final View view, final int visibility) {
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            view.setVisibility(visibility);
        }
    });
}