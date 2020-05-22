ByteArrayOutputStream stream = new ByteArrayOutputStream();
Bitmap resizedBitmap = Bitmap.createScaledBitmap(thumbnail, 150, 150, false);
resizedBitmap.compress(Bitmap.CompressFormat.PNG, 100,stream);
byte[] byteArray = stream.toByteArray();
String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
new ImageUpload().execute(encoded);