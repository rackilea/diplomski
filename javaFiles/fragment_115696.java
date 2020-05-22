public View getView(int position, View convertView, ViewGroup parent) {
    ImageView i = new ImageView(context);
    // Move cursor to current position
    cursor.moveToPosition(position);
    // Get the current value for the requested column
    int imageID = cursor.getInt(columnIndex);
    // obtain the image URI
    Uri uri = Uri.withAppendedPath( MediaStore.Images.Media.EXTERNAL_CONTENT_URI, Integer.toString(imageID) );
    String url = uri.toString();
    // Set the content of the image based on the image URI
    int originalImageId = Integer.parseInt(url.substring(url.lastIndexOf("/") + 1, url.length()));
    Bitmap b = MediaStore.Images.Thumbnails.getThumbnail(getContentResolver(),
                    originalImageId, MediaStore.Images.Thumbnails.MINI_KIND, null);
    i.setImageBitmap(b);
    i.setLayoutParams(new Gallery.LayoutParams(150, 100));
    i.setScaleType(ImageView.ScaleType.FIT_XY);
    i.setBackgroundResource(mGalleryItemBackground);
    return i;
}