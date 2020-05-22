if (data != null) {
    Uri photoUri = data.getData();
    // Do something with the photo based on Uri
    Bitmap selectedImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoUri);
    // Load the selected image into a preview
    ImageView ivPreview = (ImageView) findViewById(R.id.ivPreview);
    ivPreview.setImageBitmap(selectedImage);   
}