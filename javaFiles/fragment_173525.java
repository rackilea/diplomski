public static Drawable getDrawableFromUrl(String url, Context context) throws IOException {
    Bitmap x;

    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
    connection.connect();
    InputStream inputStream = connection.getInputStream();
    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

    BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
bufferedInputStream.mark(connection.getContentLength());
BitmapFactory.decodeStream(bufferedInputStream, null, options);
bufferedInputStream.reset();

options.inJustDecodeBounds = false;
options.inSampleSize = calculateInSampleSize(options, 400, 400);

x = BitmapFactory.decodeStream(bufferedInputStream, null, options);

bufferedInputStream.close();
connection.disconnect();

    BitmapDrawable y = new BitmapDrawable(x);

    return y;
}