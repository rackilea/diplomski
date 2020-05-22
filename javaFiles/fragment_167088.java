private void saveImage(Bitmap finalBitmap, String image_name) {

    String root = Environment.getExternalStorageDirectory().toString();
    File myDir = new File(root);
    myDir.mkdirs();
    String fname = "Image-" + image_name+ ".jpg";
    File file = new File(myDir, fname);
    if (file.exists()) file.delete();
    try {
        FileOutputStream out = new FileOutputStream(file);
        finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
        out.flush();
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}