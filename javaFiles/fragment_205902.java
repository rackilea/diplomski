protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (resultCode != RESULT_OK) {
        return;
    }

    switch (requestCode) {
        case PICK_FROM_CAMERA:
            if (data != null && "inline-data".equals(data.getAction())) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.getParcelable("data");
                mImageView.setImageBitmap(imageBitmap);
            }
            else {
                Intent intent = new Intent(this, CropImage.class);
                intent.putExtra("image-path", mImageCaptureUri.getPath());
                intent.putExtra("scale", true);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, 1);
            }
            break;
    }

}