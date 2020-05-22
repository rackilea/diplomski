public View getView(int position, View convertView, ViewGroup parent) {

    final ImageView imageView;
       // set the imagge's bounds if it is not loaded yet
    if (convertView == null) {
        imageView = new ImageView(mContext);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(imageSize, imageSize));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(0, 0, 0, 0);
    }
    else {
        imageView = (ImageView) convertView;
    }

    final String imageKey = photoGalleryModels[position].thumb_image_url;
    final Bitmap bitmapImage = mMemoryCache.get(imageKey);

    if (bitmapImage != null) {
        imageView.setImageBitmap(bitmapImage);
    }
    else {
        imageView.setImageBitmap(emptyBitmap);
        DownloadImageWithURL(photoGalleryModels[position].thumb_image_url, new MyHttpCallback() {
            @Override
            public void MyHttpCallback_OnSuccess(Object data, String responseString) {
                    if (data instanceof Bitmap) {
                    mMemoryCache.put(imageKey, (Bitmap)data);
                    imageView.setImageBitmap((Bitmap)data);
                }
            }

            @Override
            public void MyHttpCallback_OnError(String responseString, ErrorDataModel error)
            {}
        });
    }
    convertView = imageView;
    return convertView;
}