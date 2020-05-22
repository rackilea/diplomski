private Drawable getQuestionImageDrawable(int questionNumber) {
Drawable image;
URL imageUrl;

try {
    // Create a Drawable by decoding a stream from a remote URL
    imageUrl = new URL(getQuestionImageUrl(questionNumber));
    HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
    conn.setDoInput(true);
    conn.connect();
    InputStream stream = conn.getInputStream();
    Bitmap bitmap = BitmapFactory.decodeStream(stream);
    image = new BitmapDrawable(getResources(), bitmap);
} catch (Exception e) {
    Log.e(TAG, "Decoding Bitmap stream failed");
    image = getResources().getDrawable(R.drawable.noquestion);
}
return image;
}