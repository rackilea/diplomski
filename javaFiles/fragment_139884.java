public static Bitmap convertByteArrayToBitmap(String Base64String) 
{
    byte[] data = Base64.decode(Base64String, Base64.DEFAULT);
    Bitmap bitmap = BitmapFactory.decodeByteArray(data , 0, data.length);
    return bitmap;
}