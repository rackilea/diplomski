byte[] data = null;
try {
    ContentResolver cr = mainActivity.getContentResolver();
    InputStream fis = cr.openInputStream(photoUri);
    Bitmap bi = BitmapFactory.decodeStream(fis);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    bi.compress(Bitmap.CompressFormat.JPEG, 100, baos);
    data = baos.toByteArray();              
} catch (FileNotFoundException e) {
    e.printStackTrace();
}     
Bundle params = new Bundle(); 
params.putString("method", "photos.upload");          
params.putByteArray("picture", data);