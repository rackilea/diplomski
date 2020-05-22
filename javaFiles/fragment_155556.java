FileOutputStream out = null;
try {
    out = new FileOutputStream(filename);
    mBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
    // PNG is a lossless format, the compression factor (100) is ignored
} catch (Exception e) {
    e.printStackTrace();
} finally {
    try {
        if (out != null) {
            out.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}