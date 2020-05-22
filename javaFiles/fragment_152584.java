private void handleCameraPhoto(Intent intent) {
    Bundle extras = intent.getExtras();
    Bitmap mImageBitmap = (Bitmap) extras.get("data");
    Intent intent = new Intent(this, NewActivity.class);
    intent.putExtra("BitmapImage", mImageBitmap);
    startActivity(intent);
}