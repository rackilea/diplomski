Bitmap image = memCache.get("imagefile");
if (image != null) {
    //Bitmap exists in cache.
    imageView.setImageBitmap(image); 
} else {
    //Bitmap not found in cache reload it 
    Glide.with(context)
         .load(Uri.parse("file:///android_asset/imagefile"))
         .into(imageView);
}