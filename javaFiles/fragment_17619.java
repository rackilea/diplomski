public static class GetBitmapTask implements Runnable {

    private final String uri;
    private final Callback callback;

    public GetBitmapTask(String uri, Callback callback) {
        this.uri = uri;
        this.callback = callback;
    }

    @Override public void run() {
        try {
            URL url = new URL(uri);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            callback.onFinish(bmp);
        } catch (IOException e) {
            callback.onError(e);
        }
    }

    public interface Callback{
        void onFinish(Bitmap bitmap);
        void onError(Throwable t);
    }
}