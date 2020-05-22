ImageLoader imageLoader = AppController.getInstance().getImageLoader();
 
// If you are using normal ImageView
imageLoader.get(Const.URL_IMAGE, new ImageListener() {
 
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e(TAG, "Image Load Error: " + error.getMessage());
    }
 
    @Override
    public void onResponse(ImageContainer response, boolean arg1) {
        if (response.getBitmap() != null) {
            // load image into imageview
            imageView.setImageBitmap(response.getBitmap());
        }
    }
});