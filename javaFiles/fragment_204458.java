//For encoding toString
public String getStringImage(Bitmap bmp){
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);
    byte[] imageBytes = baos.toByteArray();
    String encodedImage = android.util.Base64.encodeToString(imageBytes, Base64.DEFAULT);
    return encodedImage;
}
//For decoding
String str=encodedImage;
byte data[]= android.util.Base64.decode(str, android.util.Base64.DEFAULT);
Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);