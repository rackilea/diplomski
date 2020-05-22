public static File saveImage(final Context context, final String imageData) {
    final byte[] imgBytesData = android.util.Base64.decode(imageData,
            android.util.Base64.DEFAULT);

    final File file = File.createTempFile("image", null, context.getCacheDir());
    final FileOutputStream fileOutputStream;
    try {
        fileOutputStream = new FileOutputStream(file);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        return null;
    }

    final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
            fileOutputStream);
    try {
        bufferedOutputStream.write(imgBytesData);
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    } finally {
        try {
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return file;
}