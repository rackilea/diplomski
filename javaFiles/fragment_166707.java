Bitmap bitmap = getBitmapfromUrl(imageurl);
imageview.setImageBitmap(bitmap);

SaveImage(bitmap);

public Bitmap getBitmapfromUrl(String imageUrl) {
    try {
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.connect();
        InputStream input = connection.getInputStream();
        Bitmap bitmap = BitmapFactory.decodeStream(input);
        return bitmap;

    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return null;

    }
}

private void SaveImage(Bitmap finalBitmap) {

    String root = Environment.getExternalStorageDirectory().toString();
    File myDir = new File(root + "/saved_images");
    myDir.mkdirs();
    Random generator = new Random();
    int n = 10000;
    n = generator.nextInt(n);
    String fname = "Image-" + n;
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