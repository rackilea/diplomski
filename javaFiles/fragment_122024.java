HandlerThread thread = new HandlerThread("MyThread");
thread.start();
Handler handler = new Handler(thread.getLooper());
handler.post(new Runnable() {
    @Override
    public void run() {
        Bitmap myBitmap = null;
        try {
            URL url = new URL("http://icons.iconarchive.com/icons/mazenl77/I-like-buttons-3a/512/Cute-Ball-Go-icon.png");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            myBitmap = BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (myBitmap == null) {
            Log.e("TAG", "Fetch failed");
        } else {
            Log.e("TAG", myBitmap.toString());
        }
    }
});