/**
 * @param encodedString
 * @return bitmap (from given string)
 */
public Bitmap StringToBitMap(String encodedString){
   try {
      byte [] encodeByte=Base64.decode(encodedString,Base64.DEFAULT);
      Bitmap bitmap=BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
      return bitmap;
   } catch(Exception e) {
      e.getMessage();
      return null;
   }
}