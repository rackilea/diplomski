public static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    ImageView imageView;

    public DownloadImageTask(ImageView bmImage) {
        this.imageView = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap imageBitmap = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            imageBitmap = BitmapFactory.decodeStream(in);
        } catch (IOException e) {
            // Probably there's no Internet connection. Warn the user about checking his/her connection.
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return imageBitmap;
    }

    protected void onPostExecute(Bitmap result) {
        if (imageView != null) imageView.setImageBitmap(result);
    }

}