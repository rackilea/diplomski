Uri imgUri;
Bitmap bitmap = null;
try {
    InputStream inputStream = getContentResolver().openInputStream(imgUri);
    bitmap = BitmapFactory.decodeStream(inputStream);
} catch (FileNotFoundException e) {
}