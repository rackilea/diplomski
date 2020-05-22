class AsyncForBitmap extends AsyncTask<String, Void, Bitmap> {

    private final ImageView mImageView;

    public AsyncForBitmap(ImageView imageView){
        mImageView = imageView;
    }

    private Exception exception;

    protected Bitmap doInBackground(String... urls) {
        try {
            URL url=new URL(urls[0]);
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)url.getContent());
            return bitmap;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Bitmap bitmap){
        mImageView.setImageBitmap(bitmap);
    }

}