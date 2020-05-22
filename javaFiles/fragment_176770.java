@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     // verify the successful completion of picture taken
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

        // get the bundle 
        Bundle extras = data.getExtras();

        // imageBitmap will hold the image you are looking for 
        Bitmap imageBitmap = (Bitmap) extras.get("data");

        // optionally you can display this pic in some ImageView or can delete this line
        mImageView.setImageBitmap(imageBitmap);
    }
}