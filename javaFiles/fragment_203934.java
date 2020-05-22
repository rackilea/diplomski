Bitmap bm=null;
if (data != null) {
    try {
        bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
    } catch (IOException e) {
        e.printStackTrace();
    }
}