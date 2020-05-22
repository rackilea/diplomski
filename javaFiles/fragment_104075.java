public Bitmap getBitmap(String path) {
try {
    Bitmap bitmap=null;
    File f= new File(path);
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inPreferredConfig = Bitmap.Config.ARGB_8888;

        bitmap = BitmapFactory.decodeStream(new FileInputStream(f), null, options);
     image.setImageBitmap(bitmap);
} catch (Exception e) {
    e.printStackTrace();
    return null;
}}