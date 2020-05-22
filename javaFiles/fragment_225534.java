@Override
protected void onActivityResult(int requestCode, int resultcode, Intent intent) {
    if (requestCode == REQUEST_TAKE_PHOTO && resultcode == RESULT_OK) {
        Uri uri = intent.getData();
        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        image.setImageBitmap(bitmap);
    }
}