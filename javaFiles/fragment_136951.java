setimageView(imageView1, i, imageFile);

private void setimageView(ImageView imageView, int i, File imageFile) {
    if(files.get(i).endsWith("mp4")){
        Bitmap bMap = ThumbnailUtils.createVideoThumbnail(imageFile.getAbsolutePath(),
                MediaStore.Video.Thumbnails.MINI_KIND);
        imageView.setImageBitmap(bMap);
    } else {
        imageView.setImageURI(null);
        imageView.setImageURI(Uri.parse(path + files.get(i)));
        imageView.setRotation(rotate);
    }
    imageView.invalidate();
    Log.d("onCreate", "imageView set: " + path+files.get(i) + " rotation: " + rotate);
}