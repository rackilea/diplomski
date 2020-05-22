public void requestArticleList(final Callback<MyResult> callback) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            // your code
            callback.onResult(result);
        }
    }).start();
}