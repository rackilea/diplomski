if (requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK) {
    Bitmap selectedImage = (Bitmap)data.getParcelableExtra("data");
    // Load the selected image into a preview
    ImageView ivPreview = (ImageView) findViewById(R.id.ivPreview);
    ivPreview.setImageBitmap(selectedImage);   
}