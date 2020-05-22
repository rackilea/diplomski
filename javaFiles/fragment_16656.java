//1. Decode data from image file
Bitmap bm = BitmapFactory.decodeFile(imagePath);
...
//2. Compress decoded image data to JPEG format with max quality
bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
...
//3. Encode compressed image data to base64
out.write(data);
...
//4. Compress to gzip format, before encoding gzipped data to base64
base64Str = Base64.encodeBytes(encoded, Base64.GZIP);