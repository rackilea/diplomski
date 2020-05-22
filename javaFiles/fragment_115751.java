class picture_get  extends AsyncTask<String, Bitmap, Bitmap> {

    @Override
    protected Bitmap doInBackground(String... params) {
        URL img_value = null;
        try {
            img_value = new URL("https://graph.facebook.com/"+id+"picture?type=large");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            bitmap_pic = BitmapFactory.decodeStream(img_value.openConnection().getInputStream());
            Log.i("bitmap_pic_get", "ok");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //bitmap_pic = Bitmap.createScaledBitmap(bitmap_pic, 50, 50, false);
        return bitmap_pic ;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap_pic) {
    image1.setImageBitmap(bitmap_pic);       
    }
}